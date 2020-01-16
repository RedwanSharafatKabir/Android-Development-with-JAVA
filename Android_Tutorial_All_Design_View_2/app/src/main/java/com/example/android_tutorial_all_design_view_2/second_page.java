package com.example.android_tutorial_all_design_view_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class second_page extends AppCompatActivity implements View.OnClickListener{

    EditText input2;
    TextView text1;
    Button btn2;
    SearchView searchView;
    ListView list1, list2;
    int [] flag = {R.drawable.afghanistan, R.drawable.bangladesh, R.drawable.canada,
            R.drawable.denmark, R.drawable.egypt};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        input2 = findViewById(R.id.inputTextID2);
        text1 = findViewById(R.id.outputTextID1);

        btn2 = findViewById(R.id.dataPassButtonID2);
        btn2.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String value = bundle.getString("key_name");
            text1.setText(value);
        }
////////////////////////////////////////////////////////////////////////////////////////////
///////////////////               ArrayAdapter                //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
//        final String country[] = getResources().getStringArray(R.array.country_array);
//        list1 = findViewById(R.id.listViewID1);
//        ArrayAdapter<String> adpt = new ArrayAdapter<String>(second_page.this, R.layout.activity_third_page, R.id.UniqueTextViewID, country);
//        list1.setAdapter(adpt);
//        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String value = country[position];
//                Toast.makeText(second_page.this, value + " is beautiful", Toast.LENGTH_LONG).show();
//            }
//        });

////////////////////////////////////////////////////////////////////////////////////////////
///////////////////               CustomAdapter                /////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
        final String country[] = getResources().getStringArray(R.array.country_array);
        list2 = findViewById(R.id.listViewID1);
        final CustomAdapter adapter = new CustomAdapter(this, country, flag);
        list2.setAdapter(adapter);

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = country[position];
                Toast.makeText(second_page.this, value + " is beautiful", Toast.LENGTH_LONG).show();
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////
///////////////////                SearchView                 //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
        searchView = findViewById(R.id.searchID);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
                if (TextUtils.isEmpty(newText)) {
                    list2.clearTextFilter();
                } else {
                    list2.setFilterText(newText);
                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.dataPassButtonID2){
            String st = input2.getText().toString(), name = "key_name2";
            Intent it = new Intent(second_page.this, MainActivity.class);
            it.putExtra(name, st);
            setResult(1, it);
            finish();
            input2.setText(null);
//            startActivity(it);
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////
///////////////////                  MenuBar                  //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.seetingID1){
            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
            return true;
        }
        if(item.getItemId()==R.id.seetingID2){
            Toast.makeText(getApplicationContext(), "Share with bluetooth", Toast.LENGTH_LONG).show();
            return true;
        }
        if(item.getItemId()==R.id.seetingID3){
            Toast.makeText(getApplicationContext(), "Redwan Sharafat Kabir\n       ID: 171-15-8737", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
