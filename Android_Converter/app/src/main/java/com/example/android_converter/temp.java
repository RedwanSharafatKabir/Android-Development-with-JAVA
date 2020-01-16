package com.example.android_converter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class temp extends AppCompatActivity implements View.OnClickListener{

    TextView output;
    Button cTof, fToc, convert, refresh;
    EditText input;
    Double temp;
    String st1, st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature);

        cTof = (Button)findViewById(R.id.CtoFID);
        cTof.setOnClickListener(this);
        fToc = (Button)findViewById(R.id.FtoCID);
        fToc.setOnClickListener(this);
        convert = (Button)findViewById(R.id.convertID);
        convert.setOnClickListener(this);
        refresh = (Button)findViewById(R.id.refreshID);
        refresh.setOnClickListener(this);

        output = findViewById(R.id.TempoutputID);
        input = (EditText) findViewById(R.id.TempinputID);
    }
    @Override
    public void onClick(View v) {
        try{
            if(v.getId()==R.id.CtoFID){
                st1 = "°F";
                st2 = null;
            }
            if(st1 != null) {
                if (v.getId() == R.id.convertID) {
                    temp = Double.parseDouble(input.getText().toString());
                    output.setText((temp*9/5+32) + st1);
                }
            }

            if(v.getId()==R.id.FtoCID){
                st2 = "°C";
                st1 = null;
            }
            if(st2 != null) {
                if (v.getId() == R.id.convertID) {
                    temp = Double.parseDouble(input.getText().toString());
                    output.setText(((temp-32)*5/9) + st2);
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
