package com.example.all_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Frame_Layout extends AppCompatActivity implements View.OnClickListener{

    ImageView vegeta, kale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame__layout);

        vegeta = findViewById(R.id.vegetaID);
        vegeta.setOnClickListener(this);

        kale = findViewById(R.id.kaleID);
        kale.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.vegetaID){
            vegeta.setVisibility(View.GONE);
            kale.setVisibility(View.VISIBLE);
        }
        if(view.getId()==R.id.kaleID){
            kale.setVisibility(View.GONE);
            vegeta.setVisibility(View.VISIBLE);
        }
    }
}
