package com.example.android_tutorial_all_design_view;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class seekbar extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    SeekBar seekbar;
    TextView textoutput, dateoutputText;
    Switch switchBut;
    Button nextpage2, dateButton;
    DatePicker datepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar);

        seekbar = findViewById(R.id.seekBarID1);
        seekbar.setOnSeekBarChangeListener(this);

        textoutput = findViewById(R.id.seekbarOutputID);
        textoutput.setText("Volume " + seekbar.getProgress() + "/" + seekbar.getMax());

        switchBut = findViewById(R.id.switchID);
        switchBut.setOnCheckedChangeListener(this);

        dateoutputText = findViewById(R.id.DateOutputID);

        nextpage2 = findViewById(R.id.NextPageID2);
        nextpage2.setOnClickListener(this);

        dateButton = findViewById(R.id.datebuttonID);
        dateButton.setOnClickListener(this);

        datepicker = findViewById(R.id.datePickerID);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textoutput.setText("Volume " + progress + "/" + seekbar.getMax());
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast t = Toast.makeText(seekbar.this, "Don't touch me.", Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER, 0,0);
        t.show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast t = Toast.makeText(seekbar.this, "Please hold me tight.", Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER, 0,0);
        t.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            Toast t = Toast.makeText(seekbar.this, "On", Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER, 0,0);
            t.show();
        }
        else {
            Toast t = Toast.makeText(seekbar.this, "Off", Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER, 0,0);
            t.show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.datebuttonID) {
            dateoutputText.setText(currentDate());
        }
        if(v.getId()==R.id.NextPageID2){
            Intent intent = new Intent(seekbar.this, thirdPage.class);
            startActivity(intent);
        }
    }

    String currentDate(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(datepicker.getDayOfMonth() + "-");
        stringBuilder.append((datepicker.getMonth()+1) + "-");
        stringBuilder.append(datepicker.getYear());

        return stringBuilder.toString();
    }
}
