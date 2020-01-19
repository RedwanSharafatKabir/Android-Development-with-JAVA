package com.example.android_gridview_spinner_progressbar_splashscreen_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String [] country;
    GridView gridView;
    Button but;
    int [] flag = {R.drawable.afghanistan, R.drawable.bangladesh, R.drawable.canada,
            R.drawable.denmark, R.drawable.egypt};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // remove notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        setTitle("Gridview");

        gridView = findViewById(R.id.gridViewID);
        country = getResources().getStringArray(R.array.country_array);

        final CustomAdapter adapter = new CustomAdapter(this, country, flag);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = country[position];
                Toast.makeText(MainActivity.this, value + " is beautiful", Toast.LENGTH_LONG).show();
            }
        });

        but = findViewById(R.id.spinnerPageID);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), spinner.class);
                startActivity(intent);
            }
        });
    }
}
