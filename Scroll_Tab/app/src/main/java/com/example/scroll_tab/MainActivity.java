package com.example.scroll_tab;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.ViewPagerID);

        // Fragment এর Object
        FragmentManager fragmentManager = getSupportFragmentManager();

        // CustomAdapter Class এর Object
        CustomerAdapter obj = new CustomerAdapter(fragmentManager);
        viewPager.setAdapter(obj);
    }
}

class CustomerAdapter extends FragmentStatePagerAdapter {

    public CustomerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position==0){
            fragment = new FragmentOne();
        }
        if(position==1){
            fragment = new FragmentTwo();
        }
        if(position==2){
            fragment = new FragmentThree();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        // Total number of fragment pages
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "tab1";
        }
        if(position==1){
            return "tab2";
        }
        if(position==2){
            return "tab3";
        }
        return null;
    }
}
