package com.example.toolbar_actionbar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button but1, but2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = findViewById(R.id.button1);
        but1.setOnClickListener(this);

        but2 = findViewById(R.id.button2);
        but2.setOnClickListener(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button1){
            Intent it = new Intent("com.example.android_gridview_spinner_progressbar_splashscreen_mediaplayer.MainActivity");
            startActivity(it);
        }
        if(v.getId()==R.id.button2){
            Intent it = new Intent(getApplicationContext(), Second.class);
            startActivity(it);
        }
    }
}
