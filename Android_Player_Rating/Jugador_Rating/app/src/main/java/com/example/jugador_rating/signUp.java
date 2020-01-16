package com.example.jugador_rating;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class signUp extends AppCompatActivity implements View.OnClickListener{

    ProgressBar progress;
    TextView passWarn;
    Button signupbut;
    EditText Editemail, Editpass, confirmpass, usernm;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progress = findViewById(R.id.ProgressBarID);
        passWarn = findViewById(R.id.passWarnID);

        signupbut = findViewById(R.id.signUPID);
        signupbut.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        Editemail = findViewById(R.id.emailID);
        usernm = findViewById(R.id.signupusernameID);
        Editpass = findViewById(R.id.signuppassID);
        confirmpass = findViewById(R.id.signupConfirmpassID);
    }

    @Override
    public void onClick(View v) {

        String email = Editemail.getText().toString().trim();
        String usernmobj = usernm.getText().toString();
        String password = Editpass.getText().toString().trim();
        String confirmpasobj = confirmpass.getText().toString().trim();

        if (v.getId() == R.id.signUPID) {

            if( email.matches("") || usernmobj.matches("") ||
                password.isEmpty() || confirmpasobj.isEmpty()) {
                Toast t = Toast.makeText(signUp.this, "Fill up all required fields", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast t = Toast.makeText(signUp.this, "Invalid email address", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();
                Editemail.requestFocus();
                return;
            }
            progress.setVisibility(View.VISIBLE);

            if (password.length() < 8) {
                passWarn.setText("Password is too short\nMinimum length of password should be 8");
            }
            if (password.matches(confirmpasobj)) {

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progress.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast toast = Toast.makeText(signUp.this, "Successfully Registered", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();

                            Intent log = new Intent(signUp.this, login.class);
                            startActivity(log);
                        } else {
                            Toast toast = Toast.makeText(signUp.this, "Failed", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast t = Toast.makeText(signUp.this, "User is already registered", Toast.LENGTH_LONG);
                                t.setGravity(Gravity.CENTER, 0, 0);
                                t.show();
                            }
                            else{
                                Toast t = Toast.makeText(signUp.this, "Error : " + task.getException().getMessage(), Toast.LENGTH_LONG);
                                t.setGravity(Gravity.CENTER, 0, 0);
                                t.show();
                            }
                        }
                    }
                });
            }
            else {
                Toast toast = Toast.makeText(signUp.this, "Password did not match", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }

            Editemail.setText("");
            usernm.setText("");
            Editpass.setText("");
            confirmpass.setText("");
        }
    }
}
