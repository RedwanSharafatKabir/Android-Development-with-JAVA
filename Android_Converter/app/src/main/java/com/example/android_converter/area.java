package com.example.android_converter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class area extends AppCompatActivity implements View.OnClickListener{

    TextView output;
    Button iToc, cToi, fTom, mTof, convert, refresh;
    EditText input;
    Double temp;
    String st1, st2, st3, st4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area);

        iToc = (Button)findViewById(R.id.ItoCID);
        iToc.setOnClickListener(this);
        cToi = (Button)findViewById(R.id.CtoIID);
        cToi.setOnClickListener(this);
        fTom = (Button)findViewById(R.id.FtoMID);
        fTom.setOnClickListener(this);
        mTof = (Button)findViewById(R.id.MtoFID);
        mTof.setOnClickListener(this);
        convert = (Button)findViewById(R.id.convertID);
        convert.setOnClickListener(this);
        refresh = (Button)findViewById(R.id.refreshID);
        refresh.setOnClickListener(this);

        output = findViewById(R.id.AreaoutputID);
        input = (EditText) findViewById(R.id.AreainputID);
    }

    @Override
    public void onClick(View v) {
        try{
            if(v.getId()==R.id.ItoCID){
                st1 = " cm";
                st2 = null;
            }
            if(st1 != null) {
                if (v.getId() == R.id.convertID) {
                    temp = Double.parseDouble(input.getText().toString());
                    output.setText((temp*2.5401) + st1);
                }
            }

            if(v.getId()==R.id.CtoIID){
                st2 = " inch";
                st1 = null;
            }
            if(st2 != null){
                if (v.getId() == R.id.convertID) {
                    temp = Double.parseDouble(input.getText().toString());
                    output.setText((temp/2.5401) + st2);
                }
            }

            if(v.getId()==R.id.MtoFID){
                st3 = " ft";
                st4 = null;
            }
            if(st3!=null){
                if(v.getId()==R.id.convertID){
                    temp = Double.parseDouble(input.getText().toString());
                    output.setText((temp*3.2808399) + st3);
                }
            }

            if(v.getId()==R.id.FtoMID){
                st4 = " mtr";
                st3 = null;
            }
            if(st4 != null) {
                if (v.getId() == R.id.convertID) {
                    temp = Double.parseDouble(input.getText().toString());
                    output.setText((temp/3.2808399) + st4);
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
