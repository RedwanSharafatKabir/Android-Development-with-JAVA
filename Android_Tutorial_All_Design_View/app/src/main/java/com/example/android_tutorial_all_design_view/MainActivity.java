package com.example.android_tutorial_all_design_view;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView output2, output3;
    Button playButton, watchButton, nextpage1, p3, p4;
    CheckBox input1, input2, input3;
    RadioButton resultRadioButton;
    RadioGroup radiogrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output2 = findViewById(R.id.outputID2);
        output3 = findViewById(R.id.outputID3);
        input1 = findViewById(R.id.checkboxID1);
        input2 = findViewById(R.id.checkboxID2);
        input3 = findViewById(R.id.checkboxID3);

        p3 = findViewById(R.id.page3);
        p3.setOnClickListener(this);
        p4 = findViewById(R.id.page4);
        p4.setOnClickListener(this);

        playButton = findViewById(R.id.buttonID);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                StringBuilder Finalstr = new StringBuilder();

                if(input1.isChecked()) {
                    LayoutInflater inflater = getLayoutInflater();
                    View resultToast = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toastLayoutID));

                    Toast t1 = new Toast(MainActivity.this);
                    t1.setDuration(Toast.LENGTH_LONG);
                    t1.setGravity(Gravity.CENTER, 0, 0);
                    t1.setView(resultToast);
                    t1.show();
                }
                if(input2.isChecked()) {
                    output2.setText("Princess is brutally fucked.");
                }
                else {
                    output2.setText("");
                }
                if(input3.isChecked()) {
                    String result = input3.getText().toString();
                    String FinalResult = result.concat(" is not a game.");
                    output3.setText(FinalResult);
//                    Finalstr.append(result + " is not a game.");
//                    output3.setText(Finalstr);
                }
                else {
                    output3.setText("");
                }
            }
        });

        radiogrp = findViewById(R.id.radiogrpID);
        watchButton = findViewById(R.id.buttonID2);
        watchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder Finalstr = new StringBuilder();

                int selectedID = radiogrp.getCheckedRadioButtonId();
                resultRadioButton = (RadioButton) findViewById(selectedID);
                String str = resultRadioButton.getText().toString();

                Finalstr.append("No " + str + " today.");

                Toast t2 = Toast.makeText(MainActivity.this, Finalstr, Toast.LENGTH_LONG);
                t2.setGravity(Gravity.CENTER, 0, 500);
                t2.show();
            }
        });

        nextpage1 = findViewById(R.id.NextPageID1);
        nextpage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, seekbar.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.page3){
            Intent t2 = new Intent(MainActivity.this, thirdPage.class);
            startActivity(t2);
        }
        if(v.getId()==R.id.page4){
            Intent t3 = new Intent(MainActivity.this, fourthPage.class);
            startActivity(t3);
        }
    }
}
