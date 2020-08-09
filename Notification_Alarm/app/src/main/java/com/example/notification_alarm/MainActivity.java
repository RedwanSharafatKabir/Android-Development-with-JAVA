package com.example.notification_alarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TimePicker timePicker;
    Button sendNotofication, setAlarm;
    TextView notificationOutput;
    Ringtone r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendNotofication = findViewById(R.id.notificationSendID);
        sendNotofication.setOnClickListener(this);
        setAlarm = findViewById(R.id.setAlarmBtnID);
        setAlarm.setOnClickListener(this);
        notificationOutput = findViewById(R.id.notificationSentMessageID);
        timePicker = findViewById(R.id.timePickerID);
//        timePicker.setIs24HourView(true);

        r = RingtoneManager.getRingtone(getApplicationContext(),
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
    }

    public String alarmTime(){
        Integer currentHour = timePicker.getCurrentHour();
        Integer currentMinute = timePicker.getCurrentMinute();

        String alarmTimeString, alarmMinuteString;

        if(currentMinute<10){
            alarmMinuteString = "0";
            alarmMinuteString.concat(alarmMinuteString.concat(currentMinute.toString()));
        } else {
            alarmMinuteString = currentMinute.toString();
        }

        if(currentHour>12){
            currentHour-=12;
            alarmTimeString = currentHour.toString().concat(":").concat(alarmMinuteString).concat(" PM");
        } else {
            alarmTimeString = currentHour.toString().concat(":").concat(alarmMinuteString).concat(" AM");
        }

        return alarmTimeString;
    }

    public void currentTimeMatchMethod(){
        /* print current time / date */
//        String currentDateTimeString = java.text.DateFormat.getTimeInstance().format(new Date());
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
                                // "hh:mm a" is standard format
                                String matchTimeString = simpleDateFormat.format(calendar.getTime());
                                notificationOutput.setText(matchTimeString);
                            }
                        });
                    }
                } catch (Exception e){Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();}
            }
        }; thread.start();
    }

    public void matchTime(){
        currentTimeMatchMethod();
        Toast.makeText(getApplicationContext(), alarmTime(), Toast.LENGTH_SHORT).show();

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(notificationOutput.getText().toString().equals(alarmTime())){
                    r.play();
                } else {
                    r.stop();
                }
            }
        }, 0, 1000);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.setAlarmBtnID){
            matchTime();
        }

        if(v.getId() == R.id.notificationSendID){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                NotificationChannel channel = new NotificationChannel("ChannelID", "ChannelID",
                        NotificationManager.IMPORTANCE_DEFAULT);

                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                    this, "ChannelID")
                    .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                    .setContentTitle("Message received successfully")
                    .setContentText("Notification sent successfully")
                    .setAutoCancel(true);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
            managerCompat.notify(999, builder.build());
        }
    }
}
