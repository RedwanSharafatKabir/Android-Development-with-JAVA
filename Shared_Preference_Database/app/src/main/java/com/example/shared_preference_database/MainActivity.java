package com.example.shared_preference_database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout linearLayout;
    TextView textView, score;
    EditText pass, name;
    Button btn1, btn2, inc, dec;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Hiding action bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayoutID);

        if(loadColor()!=getResources().getColor(R.color.colorPrimaryDark)){
            linearLayout.setBackgroundColor(loadColor());
        }

        textView = findViewById(R.id.detailsID);
        score = findViewById(R.id.scoreID);

        name = findViewById(R.id.usernameID);
        pass = findViewById(R.id.passwordID);

        btn1 = findViewById(R.id.saveID);
        btn2 = findViewById(R.id.loadID);
        inc = findViewById(R.id.increaseID);
        dec = findViewById(R.id.decreaseID);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        inc.setOnClickListener(this);
        dec.setOnClickListener(this);

        score.setText("Score: " + count);

        if(loadScore()!=0){
            score.setText("Score: " + loadScore());
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.saveID){
            String username = name.getText().toString();
            String password = pass.getText().toString();

            if(username.equals("") && password.equals("")){
                Toast.makeText(MainActivity.this, "Please fill the required fields", Toast.LENGTH_LONG).show();
            }
            else {
                /// Data writing code
                SharedPreferences sharedPreferences = getSharedPreferences("User Details", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("UserNameKey",username);
                editor.putString("PasswordKey",password);
                editor.commit();

                Toast.makeText(MainActivity.this, "Data stored successfully", Toast.LENGTH_LONG).show();
            }

            name.setText(null);
            pass.setText(null);
        }

        if(v.getId()==R.id.loadID){
            SharedPreferences sharedPreferences = getSharedPreferences("User Details", Context.MODE_PRIVATE);

            if(sharedPreferences.contains("UserNameKey") && sharedPreferences.contains("PasswordKey")){
                String usr = sharedPreferences.getString("UserNameKey", "Data not found !");
//                String pas = sharedPreferences.getString("PasswordKey", "Data not found !");

                textView.setText( usr + "\n ID: 171-15-8737");
            }
        }

        // Score storing procedure
        if(v.getId()==R.id.increaseID){
            count+=5;
            score.setText("Score: " + count);
            saveScore(count);
        }

        if(v.getId()==R.id.decreaseID){
            count-=5;
            score.setText("Score: " + count);
            saveScore(count);
        }
    }

    public void saveScore(int count){
        SharedPreferences sharedPreferences = getSharedPreferences("Game Score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("ScoreKey",count);
        editor.commit();
    }

    public int loadScore(){
        SharedPreferences sharedPreferences = getSharedPreferences("Game Score", Context.MODE_PRIVATE);
        int lastScore = sharedPreferences.getInt("ScoreKey", 0);
        return lastScore;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.redID){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
            storeColor(getResources().getColor(R.color.red));
        }
        if(item.getItemId()==R.id.blueID){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            storeColor(getResources().getColor(R.color.blue));
        }
        if(item.getItemId()==R.id.greenID){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
            storeColor(getResources().getColor(R.color.green));
        }
        return super.onOptionsItemSelected(item);
    }

    public void storeColor(int colors){
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("myColor", colors);
        editor.commit();
    }

    public int loadColor(){
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("myColor", getResources().getColor(R.color.colorPrimaryDark));

        return selectedColor;
    }
}
