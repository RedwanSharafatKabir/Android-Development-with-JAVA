package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private Button saveBtn, showDataBtn, updatePageBtn;
    private EditText name, age, gender;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.Name);
        age = findViewById(R.id.Age);
        gender = findViewById(R.id.Gender);
        textView = findViewById(R.id.outputId);
        saveBtn = findViewById(R.id.saveButtonId);
        saveBtn.setOnClickListener(this);
        showDataBtn = findViewById(R.id.showDataButtonId);
        showDataBtn.setOnClickListener(this);
        updatePageBtn = findViewById(R.id.updatePageId);
        updatePageBtn.setOnClickListener(this);
        myDatabaseHelper = new MyDatabaseHelper(this);
    }

    @Override
    public void onClick(View v) {
        String nameText = name.getText().toString();
        String ageText = age.getText().toString();
        String genderText = gender.getText().toString();

        if(v.getId()==R.id.saveButtonId){
            if(nameText.isEmpty()){
                name.setError("Fill Name field");
            }

            if(ageText.isEmpty()){
                age.setError("Fill Age field");
            }

            if(genderText.isEmpty()){
                gender.setError("Fill Gender field");
            }

            else {
                long rowId = myDatabaseHelper.insertData(nameText, ageText, genderText);
                if(rowId == -1){
                    Toast.makeText(this, "Row not inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Row " + rowId + " is successfully inserted", Toast.LENGTH_SHORT).show();
                }
            }
        }

        if(v.getId()==R.id.showDataButtonId){
            Cursor cursor =  myDatabaseHelper.retrieveData();
            if(cursor.getCount()==0){
                Toast.makeText(this, "Database is empty", Toast.LENGTH_LONG).show();
            }

            StringBuffer stringBuffer = new StringBuffer();
            while (cursor.moveToNext()){
                stringBuffer.append("Id: " + cursor.getString(0) + "\n");
                stringBuffer.append("Name: " + cursor.getString(1) + "\n");
                stringBuffer.append("Age: " + cursor.getString(2) + "\n");
                stringBuffer.append("Gender: " + cursor.getString(3) + "\n\n");
            }

            textView.setText(stringBuffer.toString());
        }

        if(v.getId()==R.id.updatePageId){
            Intent intent = new Intent(getApplicationContext(), UpdateData.class);
            startActivity(intent);
            finish();
        }
    }
}
