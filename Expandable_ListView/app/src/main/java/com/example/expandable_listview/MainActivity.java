package com.example.expandable_listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CustomAdapter customAdapter;
    ExpandableListView expandableListView;
    List<String> array_list_header;
    HashMap<String, List<String>> array_list_child;
    int lastExpandProcess = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Menu Items");

        prepareData();
        expandableListView = findViewById(R.id.expandableListViewID);
        customAdapter = new CustomAdapter(this,array_list_header,array_list_child);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String value = array_list_header.get(groupPosition);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_LONG).show();
                return false;
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(MainActivity.this, "Closed", Toast.LENGTH_LONG).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String value = array_list_child.get(array_list_header.get(groupPosition)).get(childPosition);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_LONG).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandProcess !=-1 && lastExpandProcess !=groupPosition){
                    expandableListView.collapseGroup(lastExpandProcess);
                }
                lastExpandProcess = groupPosition;
            }
        });
    }

    public void prepareData(){
//        String [] head = getResources().getStringArray(R.array.list_header);
//        String [] child = getResources().getStringArray(R.array.list_child);

        array_list_header = new ArrayList<>();
        array_list_child = new HashMap<>();

//        for(int i=0; i<head.length;i++){
//            array_list_header.add(head[i]);
//
//            List<String> find_child = new ArrayList<>();
//            find_child.add(child[i]);
//            array_list_child.put(array_list_header.get(i), find_child);
//        }
        array_list_header.add(getString(R.string.sata));
        array_list_header.add("ASCII");
        array_list_header.add("ALGOL");
        array_list_header.add("AOL");
        array_list_header.add("API");
        array_list_header.add("BASIC");
        array_list_header.add("BIOS");

        List<String> overView1 = new ArrayList<>();
        overView1.add("Artificial Intelligence");
        overView1.add(getString(R.string.ai));

        List<String> overView2 = new ArrayList<>();
        overView2.add("American Standard Code for Information Interchange");
        overView2.add(getString(R.string.ascii));

        List<String> overView3 = new ArrayList<>();
        overView3.add("Algorithmic Language");
        overView3.add(getString(R.string.algol));

        List<String> overView4 = new ArrayList<>();
        overView4.add("America Online");
        overView4.add(getString(R.string.aol));

        List<String> overView5 = new ArrayList<>();
        overView5.add("Application Programming Interface");
        overView5.add(getString(R.string.api));

        List<String> overView6 = new ArrayList<>();
        overView6.add("Beginners All-purpose Symbolic Instruction Code");
        overView6.add(getString(R.string.basic));

        List<String> overView7 = new ArrayList<>();
        overView7.add("Basic Input/Output System");
        overView7.add(getString(R.string.bios));

        array_list_child.put(array_list_header.get(0), overView1);
        array_list_child.put(array_list_header.get(1), overView2);
        array_list_child.put(array_list_header.get(2), overView3);
        array_list_child.put(array_list_header.get(3), overView4);
        array_list_child.put(array_list_header.get(4), overView5);
        array_list_child.put(array_list_header.get(5), overView6);
        array_list_child.put(array_list_header.get(6), overView7);
    }
}
