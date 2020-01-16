package com.example.android_converter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    Button areabut, massbut, tempbut, aboutbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        areabut = (Button)findViewById(R.id.areaID);
        areabut.setOnClickListener(this);
        massbut = (Button)findViewById(R.id.massID);
        massbut.setOnClickListener(this);
        tempbut = (Button)findViewById(R.id.tempID);
        tempbut.setOnClickListener(this);
        aboutbut = (Button)findViewById(R.id.aboutID);
        aboutbut.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.areaID){
            Intent ar = new Intent(MainActivity.this, area.class);
            startActivity(ar);
        }
        if(v.getId()==R.id.massID){
            Intent ms = new Intent(MainActivity.this, mass.class);
            startActivity(ms);
        }
        if(v.getId()==R.id.tempID){
            Intent tp = new Intent(MainActivity.this, temp.class);
            startActivity(tp);
        }
        if(v.getId()==R.id.aboutID){
            Intent ab = new Intent(MainActivity.this, about.class);
            startActivity(ab);
        }
    }
}
