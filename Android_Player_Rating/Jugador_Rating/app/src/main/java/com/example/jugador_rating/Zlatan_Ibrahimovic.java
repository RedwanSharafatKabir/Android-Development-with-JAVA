package com.example.jugador_rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Zlatan_Ibrahimovic extends AppCompatActivity implements View.OnClickListener{

    RatingBar Rangeratingbar;
    Button Submitbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zlatan);

        Rangeratingbar = (RatingBar)findViewById(R.id.ZlatanratingBar1);

        Submitbutton = (Button)findViewById(R.id.rateSubmitID1);
        Submitbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.rateSubmitID1){
            String rating = String.valueOf(Rangeratingbar.getRating());
            Toast.makeText(Zlatan_Ibrahimovic.this, rating, Toast.LENGTH_LONG).show();
        }
    }
}
