package com.example.android_tutorial_all_design_view_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView text2;
    EditText input1;
    Button btn1;
    VideoView video;
    ListView listview;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCerate", Toast.LENGTH_LONG).show();
        text2 = findViewById(R.id.outputTextID2);

//        video = findViewById(R.id.videoViewID);
//        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.foundation_day_nogor_baul);
//        video.setVideoURI(uri);
//        MediaController controlMedia = new MediaController(this);
//        video.setMediaController(controlMedia);
//        video.start();

//        Bundle bundle = getIntent().getExtras();
//        if(bundle!=null){
//            String value = bundle.getString("key_name2");
//            text2.setText(value);
//        }

        input1 = findViewById(R.id.inputTextID1);

        btn1 = findViewById(R.id.dataPassButtonID1);
        btn1.setOnClickListener(this);

        final String country[] = getResources().getStringArray(R.array.country_array2);
        listview = findViewById(R.id.listViewID2);
        final ArrayAdapter<String> adpt = new ArrayAdapter<String>(MainActivity.this, R.layout.array_adapter, R.id.countryID1, country);
        listview.setAdapter(adpt);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = country[position];
                Toast.makeText(MainActivity.this, value + " is beautiful", Toast.LENGTH_LONG).show();
            }
        });

        SearchView searchView = findViewById(R.id.searchID2);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adpt.getFilter().filter(newText);
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.dataPassButtonID1){
            String str = input1.getText().toString(), name = "key_name";
            Intent it = new Intent(MainActivity.this, second_page.class);
            it.putExtra(name, str);
            input1.setText(null);
//            startActivity(it);
            startActivityForResult(it, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            String value = data.getStringExtra("key_name2");
            text2.setText(value);
        }
    }

    @Override
    public void onBackPressed() {

        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setTitle(R.string.alert_title);
        alertDialogBuilder.setMessage(R.string.alert_message);
        alertDialogBuilder.setIcon(R.drawable.exit);
        alertDialogBuilder.setCancelable(false);

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

////////////////////////////////////////////////////////////////////////////////////////////
///////////////////                  MenuBar                  //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.seetingID){
            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
            return true;
        }
        if(item.getItemId()==R.id.shareID){
            Toast.makeText(getApplicationContext(), "Share with bluetooth", Toast.LENGTH_LONG).show();
            return true;
        }
        if(item.getItemId()==R.id.aboutID){
            Toast.makeText(getApplicationContext(), "Redwan Sharafat Kabir\n       ID: 171-15-8737", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
