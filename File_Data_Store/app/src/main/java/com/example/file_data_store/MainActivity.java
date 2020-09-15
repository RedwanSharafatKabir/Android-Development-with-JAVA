package com.example.file_data_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputEditTextID);

        btn = findViewById(R.id.saveButtonID);
        btn.setOnClickListener(this);

        readData();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.saveButtonID){
            String value = inputText.getText().toString();

            if(value.equals("")){
                Toast.makeText(MainActivity.this, "Please Enter Data", Toast.LENGTH_LONG).show();
            }
            else {
                writeData(value);
            }
        }
    }

    public void writeData(String value){
        try {
            FileOutputStream fileOutputStream = openFileOutput("Personal_Diary.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(value.getBytes());
            fileOutputStream.write(value.getBytes());
            fileOutputStream.close();
            Toast.makeText(MainActivity.this, "Data saved successfully", Toast.LENGTH_LONG).show();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData(){
        try {
            FileInputStream fileInputStream = openFileInput("Personal_Diary.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuffer stringBuffer = new StringBuffer();

            while((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line + "\n");
            }
            inputText.setText(stringBuffer);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
