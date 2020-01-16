package com.example.jugador_rating;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    ProgressBar progress;
    Button loginBut, signupBut, forgotPass;
    EditText EditusernameEmail, Editpass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = findViewById(R.id.ProgressBarID);

        mAuth = FirebaseAuth.getInstance();

        loginBut = findViewById(R.id.loginID);
        loginBut.setOnClickListener(this);
        signupBut = findViewById(R.id.signUpID);
        signupBut.setOnClickListener(this);
        forgotPass = findViewById(R.id.forgotPassID);
        forgotPass.setOnClickListener(this);

        EditusernameEmail = findViewById(R.id.emailID);
        Editpass = findViewById(R.id.loginpassID);
    }

    @Override
    public void onClick(View v) {

        String email = EditusernameEmail.getText().toString();
        String password = Editpass.getText().toString();

        if (v.getId() == R.id.loginID) {

            if(email.matches("") || password.isEmpty()){
                Toast t = Toast.makeText(MainActivity.this, "Fill up all required fields", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();
            }

            if( email.matches("") || password.isEmpty()) {
                Toast t = Toast.makeText(MainActivity.this, "Fill up all required fields", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast t = Toast.makeText(MainActivity.this, "Invalid email address", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();
                EditusernameEmail.requestFocus();
                return;
            }
            progress.setVisibility(View.VISIBLE);

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progress.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        Toast toast = Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                        Intent log = new Intent(MainActivity.this, login.class);
                        startActivity(log);
                    } else {
                        Toast t = Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG);
                        t.setGravity(Gravity.CENTER, 0, 0);
                        t.show();
                    }
                }
            });

            EditusernameEmail.setText("");
            Editpass.setText("");
        }

        if(v.getId()==R.id.signUpID){
            Intent sp = new Intent(MainActivity.this, signUp.class);
            startActivity(sp);
            EditusernameEmail.setText("");
            Editpass.setText("");
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder;

        alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle(R.string.alert_title);
        alertDialogBuilder.setMessage(R.string.alert_message);
        alertDialogBuilder.setIcon(R.drawable.exit);
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
