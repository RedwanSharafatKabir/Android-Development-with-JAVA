package com.example.android_gridview_spinner_progressbar_splashscreen_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class spinner extends AppCompatActivity implements View.OnClickListener{

    ImageButton play, pause, next, previous;
    MediaPlayer mediaPlayer;
    String country[], population[];
    Spinner spinner;
    TextView textView;
    Button but1;
    int [] flag = {R.drawable.afghanistan, R.drawable.bangladesh, R.drawable.canada,
            R.drawable.denmark, R.drawable.egypt};
    int progress;
    boolean isFirstSelection = true;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // remove notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_spinner);
        setTitle("Spinner, Progress Bar");

        country = getResources().getStringArray(R.array.country_array);
        population = getResources().getStringArray(R.array.population_array);

        spinner = findViewById(R.id.spinnerID);
        textView = findViewById(R.id.SpinnerTextViewID);
        but1 = findViewById(R.id.SubmitID);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.sample_spinner_view, R.id.spinerViewID, country);
//        spinner.setAdapter(adapter);
//        but1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String value = spinner.getSelectedItem().toString();
//                textView.setText(value + " is beautiful");
//            }
//        });

        CustomAdapter2 customAdapter2 = new CustomAdapter2(this, flag, country, population);
        spinner.setAdapter(customAdapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(isFirstSelection==true){
                    isFirstSelection = false;
                }
                else{
                    String value2 = country[position];
                    textView.setText(value2 + " is beautiful");
                }

                final String value1 = country[position];
                but1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ///////////////////   ProgressBar   //////////////////////////////
                        progressBar = findViewById(R.id.progressBarID);
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                MakeItEasy();
                            }
                        });
                        thread.start();
                        //////////////////////////////////////////////////////////////////

                        Toast.makeText(spinner.this, value1 + " is selected", Toast.LENGTH_LONG).show();
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //////////////////////   MediaPlayer   ///////////////////////////
        play = findViewById(R.id.mediaPlayID);
        pause = findViewById(R.id.mediaPauseID);
        next = findViewById(R.id.mediaNextID);
        previous = findViewById(R.id.mediaPreviousID);

        mediaPlayer = MediaPlayer.create(this, R.raw.habib_wahid_jhor);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);
        //////////////////////////////////////////////////////////////////
    }

    public void MakeItEasy(){
        for(progress=20;progress<=100;progress+=20) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.mediaPlayID){
            if(mediaPlayer!=null){
                mediaPlayer.start();
                double duration = mediaPlayer.getDuration()/60000.00;
//                new DecimalFormat("##.##").format(duration);
//                String.format("%.2f", duration)
                Toast.makeText(getApplicationContext(),new DecimalFormat("##.##").format(duration) + " min",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(),"No music in storage",Toast.LENGTH_LONG).show();
            }
        }
        if(v.getId()==R.id.mediaPauseID){
            if(mediaPlayer!=null){
                mediaPlayer.pause();
                Toast.makeText(getApplicationContext(),"Paused ",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(),"No music in storage",Toast.LENGTH_LONG).show();
            }
        }
//        if(v.getId()==R.id.mediaNextID){
//            if(mediaPlayer!=null){
//                mediaPlayer.pause();
//                Toast.makeText(getApplicationContext(),"Playing ",Toast.LENGTH_LONG).show();
//            }else {
//                Toast.makeText(getApplicationContext(),"No music in storage",Toast.LENGTH_LONG).show();
//            }
//        }
//        if(v.getId()==R.id.mediaPreviousID){
//            if(mediaPlayer!=null){
//                mediaPlayer.start();
//                Toast.makeText(getApplicationContext(),"Playing ",Toast.LENGTH_LONG).show();
//            }else {
//                Toast.makeText(getApplicationContext(),"No music in storage",Toast.LENGTH_LONG).show();
//            }
//        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();
    }
}
