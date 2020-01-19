package com.example.android_gridview_spinner_progressbar_splashscreen_mediaplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int [] flag;
    String country[];
    Context context;
    LayoutInflater layoutInflater;

    //// constructor
    CustomAdapter(Context context, String country[], int flag[]){
        this.context = context;
        this.country = country;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        // number of items return করব //
        return country.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.grid_view, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.ImageViewID);
        TextView textView = convertView.findViewById(R.id.countryNameID1);

        imageView.setImageResource(flag[position]);
        textView.setText(country[position]);

        return convertView;
    }
}
