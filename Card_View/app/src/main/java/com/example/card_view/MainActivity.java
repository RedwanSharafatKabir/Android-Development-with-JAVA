package com.example.card_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView school, address, skill, interest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hiding title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Hiding action bar
        getSupportActionBar().hide();

        address = findViewById(R.id.addresID);
        school = findViewById(R.id.schoolID);
        skill = findViewById(R.id.skillsID);
        interest = findViewById(R.id.interestID);

        address.setOnClickListener(this);
        school.setOnClickListener(this);
        skill.setOnClickListener(this);
        interest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.addresID){
            Toast.makeText(MainActivity.this, "105, South Mugdapara, Dhaka", Toast.LENGTH_LONG).show();
        }
        if(v.getId()==R.id.schoolID){
            Toast.makeText(MainActivity.this, "Daffodil International University", Toast.LENGTH_LONG).show();
        }
        if(v.getId()==R.id.skillsID){
            Toast.makeText(MainActivity.this, "* Java\n* JavaScript\n* Android Studio\n* React Native", Toast.LENGTH_LONG).show();
        }
        if(v.getId()==R.id.interestID){
            Toast.makeText(MainActivity.this, "* Chess\n* Football", Toast.LENGTH_LONG).show();
        }
    }
}
