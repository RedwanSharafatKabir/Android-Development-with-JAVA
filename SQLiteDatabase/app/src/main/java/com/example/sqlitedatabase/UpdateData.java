package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity implements View.OnClickListener{

    private Button updateBtn, deleteBtn;
    private EditText id, name, age, gender;
    private TextView textView;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        id = findViewById(R.id.IdUpdate);
        name = findViewById(R.id.NameUpdate);
        age = findViewById(R.id.AgeUpdate);
        gender = findViewById(R.id.GenderUpdate);
        textView = findViewById(R.id.outputUpdatedDataId);
        updateBtn = findViewById(R.id.updateDataId);
        updateBtn.setOnClickListener(this);
        deleteBtn = findViewById(R.id.deleteDataId);
        deleteBtn.setOnClickListener(this);
        myDatabaseHelper = new MyDatabaseHelper(this);
    }

    @Override
    public void onClick(View v) {
        String idText = id.getText().toString();
        String nameText = name.getText().toString();
        String ageText = age.getText().toString();
        String genderText = gender.getText().toString();

        if(v.getId()==R.id.updateDataId){
            if(idText.isEmpty()){
                name.setError("Fill Id field");
            }

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
                Boolean isUpdated = myDatabaseHelper.updateData(idText, nameText, ageText, genderText);
                if(isUpdated==true){
                    Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show();
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

                } else {
                    Toast.makeText(this, "Data did not updated", Toast.LENGTH_LONG).show();
                }
            }
        }

        if(v.getId()==R.id.deleteDataId){
            if(idText.isEmpty()){
                name.setError("Fill Id field");
            }

            if(nameText.isEmpty() && ageText.isEmpty() && genderText.isEmpty()){
                int value = myDatabaseHelper.deleteData(idText);
                if (value > 0) {
                    Toast.makeText(this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Data did not deleted", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "To delete data you have to enter only Id value", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
