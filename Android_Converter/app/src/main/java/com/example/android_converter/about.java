package com.example.android_converter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class about extends AppCompatActivity{

    TextView aboutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        aboutText = (TextView) findViewById(R.id.descriptionID);
        aboutText.setText("This is a basic android application with length, temperature and weight converter.\n" +
                "        \n\n\n\n Built with Android Studio and Java.\n" +
                "        \n\n\n\n Instructor:  Md. Jewel Mia\n" +
                "        \n\n\nDeveloper:\n\n  Redwan Sharafat Kabir, \n Department: CSE, \n Daffodil Internationl University");
    }
}
