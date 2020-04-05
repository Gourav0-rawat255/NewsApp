package com.example.tablayout.pageradapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tablayout.fragment.Business;
import com.example.tablayout.fragment.Headline;
import com.example.tablayout.fragment.Technology;
import com.example.tablayout.fragment.Health;
import com.example.tablayout.fragment.Sport;

public class PagerAdapter extends FragmentStatePagerAdapter {

//    private Context mcontext;
    private int totaltabs;



    public PagerAdapter(@NonNull FragmentManager fm, int totaltabs) {
        super(fm);
//        mcontext = context;
        this.totaltabs= totaltabs;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Headline headline = new Headline();
                return headline;


            case 1:
                Business business = new Business();
                return business;


            case 2:
                Health health = new Health();
                return health;


            case 3:
                Sport sports = new Sport();
                return sports;
            case 4:
                Technology technology = new Technology();
                return technology;

            default:
                return null;


        }
    }

    @Override
    public int getCount() {
        return totaltabs;
    }
}
