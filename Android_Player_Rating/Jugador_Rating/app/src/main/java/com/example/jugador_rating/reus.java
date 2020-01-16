package com.example.jugador_rating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class reus extends AppCompatActivity {

    RatingBar Hazardratingbar;
    Button Submitbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reus);
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick(){
        Hazardratingbar = (RatingBar)findViewById(R.id.HazardratingBar1);

        Submitbutton = (Button)findViewById(R.id.rateHazardSubmitID1);
        Submitbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String rating=String.valueOf(Hazardratingbar.getRating());
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            }
        });
    }
}
