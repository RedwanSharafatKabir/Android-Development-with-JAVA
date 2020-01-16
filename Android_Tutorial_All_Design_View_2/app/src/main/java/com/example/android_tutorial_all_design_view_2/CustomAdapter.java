package com.example.android_tutorial_all_design_view_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.Text;

public class CustomAdapter extends BaseAdapter {

    int [] flag;
    String country[];
    Context context;
    LayoutInflater layoutInflater;

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
            convertView = layoutInflater.inflate(R.layout.activity_third_page, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.ImageViewID);
        TextView textView = convertView.findViewById(R.id.countryNameID1);

        imageView.setImageResource(flag[position]);
        textView.setText(country[position]);

        return convertView;
    }
}
