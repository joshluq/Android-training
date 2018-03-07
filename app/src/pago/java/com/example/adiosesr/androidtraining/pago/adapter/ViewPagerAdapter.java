package com.example.adiosesr.androidtraining.pago.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.adiosesr.androidtraining.pago.PlaceHolderFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PlaceHolderFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
