package com.example.expandable_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> array_list_header;
    HashMap<String, List<String>> array_list_child;

    public CustomAdapter(Context context, List<String> array_list_header, HashMap<String, List<String>> array_list_child) {
        this.context = context;
        this.array_list_header = array_list_header;
        this.array_list_child = array_list_child;
    }

    @Override
    public int getGroupCount() {
        return array_list_header.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return array_list_child.get(array_list_header.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return array_list_header.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return array_list_child.get(array_list_header.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        String headerText = (String) getGroup(groupPosition);
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.header,null);
        }
        TextView textView = view.findViewById(R.id.headerID);
        textView.setText(headerText);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        String childText = (String) getChild(groupPosition, childPosition);
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child,null);
        }
        TextView textView = view.findViewById(R.id.childID);
        textView.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
