package com.example.android_gridview_spinner_progressbar_splashscreen_mediaplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter2 extends BaseAdapter {

    int [] flag;
    String country[], population[];
    Context context;
    LayoutInflater layoutInflater;

    //// constructor
    CustomAdapter2(Context context, int flag[], String country[], String[] population){
        this.context = context;
        this.flag = flag;
        this.country = country;
        this.population = population;
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
    public View getView(int position, View SpinnerView, ViewGroup parent) {
        if(SpinnerView==null){
            layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            SpinnerView = layoutInflater.inflate(R.layout.sample_spinner_view, parent, false);
        }
        ImageView imageView = SpinnerView.findViewById(R.id.ImageViewID2);
        TextView textView1 = SpinnerView.findViewById(R.id.countryNameID2);
        TextView textView2 = SpinnerView.findViewById(R.id.countryPopulationID);

        imageView.setImageResource(flag[position]);
        textView1.setText(country[position]);
        textView2.setText(population[position]);

        return SpinnerView;
    }
}
