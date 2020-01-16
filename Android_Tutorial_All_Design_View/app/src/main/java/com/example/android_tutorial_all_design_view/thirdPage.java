package com.example.android_tutorial_all_design_view;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class thirdPage extends AppCompatActivity implements View.OnClickListener {

    TimePicker timePicker;
    TextView textView, textview2;
    Button nextPage2, button, showtime;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_page);

        textView = findViewById(R.id.textViewThirdPageID);

        textview2 = findViewById(R.id.showTimeTextID1);

        button = findViewById(R.id.dateButtonThirdPageID);
        button.setOnClickListener(this);

        showtime = findViewById(R.id.showTimeButtonID1);
        showtime.setOnClickListener(this);

        nextPage2 = findViewById(R.id.NextPageID2);
        nextPage2.setOnClickListener(this);

        timePicker = findViewById(R.id.TimePickerID1);
        timePicker.setIs24HourView(true);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.dateButtonThirdPageID) {
            DatePicker datePicker = new DatePicker(this);
            int currentDay = datePicker.getDayOfMonth();
            int currentYear = datePicker.getYear();
            int currentMonth = datePicker.getMonth();

            datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            textView.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }, currentYear, currentMonth, currentDay);

            datePickerDialog.show();
        }
        if(v.getId()==R.id.showTimeButtonID1){
//            String output = timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
            textview2.setText(currentTIme());
        }
        if(v.getId()==R.id.NextPageID2){
            Intent t = new Intent(thirdPage.this, fourthPage.class);
            startActivity(t);
        }
    }

    String currentTIme(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute());

        return stringBuilder.toString();
    }
}
