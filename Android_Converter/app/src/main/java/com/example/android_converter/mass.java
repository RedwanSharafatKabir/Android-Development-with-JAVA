package com.example.android_converter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class mass extends AppCompatActivity implements View.OnClickListener{

    TextView output;
    Button gTok, kTog, convert, refresh;
    EditText input;
    Double temp;
    String st1, st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mass);

        gTok = (Button)findViewById(R.id.GtoKID);
        gTok.setOnClickListener(this);
        kTog = (Button)findViewById(R.id.KtoGID);
        kTog.setOnClickListener(this);
        convert = (Button)findViewById(R.id.convertID);
        convert.setOnClickListener(this);
        refresh = (Button)findViewById(R.id.refreshID);
        refresh.setOnClickListener(this);

        output = findViewById(R.id.MassoutputID);
        input = (EditText) findViewById(R.id.MassinputID);
    }

    @Override
    public void onClick(View v) {
        try{
            if(v.getId()==R.id.GtoKID){
                st1 = " kg";
                st2 = null;
            }
            if(st1 != null) {
                if (v.getId() == R.id.convertID) {
                    temp = Double.parseDouble(input.getText().toString());
                    output.setText((temp/1000) + st1);
                }
            }

            if(v.getId()==R.id.KtoGID){
                st2 = " gm";
                st1 = null;
            }
            if(st2 != null){
                if (v.getId() == R.id.convertID) {
                    temp = Double.parseDouble(input.getText().toString());
                    output.setText((temp*1000) + st2);
                }
            }

        }catch(Exception e){
            Toast toastObject = Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_LONG);
            toastObject.setGravity(Gravity.CENTER, 0,0);
            toastObject.show();
        }

        if(v.getId()==R.id.refreshID){
            input.setText("");
            output.setText("");
        }
    }
}
