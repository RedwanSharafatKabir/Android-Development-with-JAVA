package com.example.menu_item_in_action_bar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity implements View.OnClickListener{

    Button send, clear;
    EditText name, email, feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        name = findViewById(R.id.nameID);
        email = findViewById(R.id.emailID);
        feedback = findViewById(R.id.feedbackID);

        send = findViewById(R.id.sendID);
        send.setOnClickListener(this);
        clear = findViewById(R.id.clearID);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            String user = name.getText().toString();
            String message = feedback.getText().toString();
            String mail = email.getText().toString();

            if (v.getId() == R.id.sendID) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                //            intent.setData(Uri.parse("mail to: "));
                intent.setType("text/plain");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mohammadmunna478@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "First feedback from user");
                intent.putExtra(Intent.EXTRA_TEXT, "Name: " + user + "\n Email address: " + mail + "\n Review: " + message);


                startActivity(Intent.createChooser(intent, "Give feedback through: "));
            }
            if (v.getId() == R.id.clearID) {
                name.setText(null);
                feedback.setText(null);
                email.setText(null);
            }
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Please enter required fields", Toast.LENGTH_LONG).show();
        }
    }
}
