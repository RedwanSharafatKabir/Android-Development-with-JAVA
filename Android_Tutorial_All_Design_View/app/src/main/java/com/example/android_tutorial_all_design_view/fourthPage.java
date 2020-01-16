package com.example.android_tutorial_all_design_view;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ZoomControls;

import androidx.appcompat.app.AppCompatActivity;

public class fourthPage extends AppCompatActivity implements View.OnClickListener {

    TextView textView, fonttext1, fonttext2;
    Button showtime, exit;
    ImageView image;
    TimePickerDialog timePickerDialog;
    AlertDialog.Builder alertDialogBuilder;
    Typeface typeface;
    ZoomControls zoompic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourthpage);

        textView = findViewById(R.id.textViewFourthPageID1);
        fonttext1 = findViewById(R.id.fontID1);
        fonttext2 = findViewById(R.id.fontID2);

        typeface = Typeface.createFromAsset(getAssets(), "font/KaushanScript_Regular.otf");
        fonttext2.setTypeface(typeface);

        showtime = findViewById(R.id.timeButtonfourthPageID);
        showtime.setOnClickListener(this);

        exit = findViewById(R.id.exitButtonfourthPageID);
        exit.setOnClickListener(this);

        image = findViewById(R.id.imageID);

        zoompic = findViewById(R.id.zoomID);
        zoompic.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double x = image.getScaleX(), y = image.getScaleX();
                if(x<4 && y<4) {
                    image.setScaleX((float) x + 1);
                    image.setScaleX((float) y + 1);
                }
            }
        });
        zoompic.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double x = image.getScaleX(), y = image.getScaleX();
                if(x>1 && y>1) {
                    image.setScaleX((float) x - 1);
                    image.setScaleX((float) y - 1);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.timeButtonfourthPageID){
            TimePicker timePicker = new TimePicker(this);
            int currentHour = timePicker.getCurrentHour();
            int currentMinute = timePicker.getCurrentMinute();

            timePickerDialog = new TimePickerDialog(fourthPage.this,
                    new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    textView.setText(hourOfDay + "-" + minute);
                }
            }, currentHour, currentMinute, true);

            timePickerDialog.show();
        }
        if(v.getId()==R.id.exitButtonfourthPageID){
            alertDialogBuilder = new AlertDialog.Builder(fourthPage.this);

            alertDialogBuilder.setTitle(R.string.alert_title);
            alertDialogBuilder.setMessage(R.string.alert_message);
            alertDialogBuilder.setIcon(R.drawable.exit);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }
}
