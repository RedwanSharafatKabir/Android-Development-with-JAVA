package com.example.android_gridview_spinner_progressbar_splashscreen_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.progressBarID);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MakeItEasy();
                startHomePage();
            }
        });
        thread.start();
    }

    public void MakeItEasy(){
        for(progress=20;progress<=100;progress+=20) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startHomePage(){
        Intent it = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(it);
        finish();
    }
}
