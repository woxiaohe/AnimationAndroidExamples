package com.nsb.chengbah.animationandroidexamples.adapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
//        return null;
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
//        return 0;
        return mFragmentList.size();
    }

    public void addFrgment(Fragment fragment){
        mFragmentList.add(fragment);
    }
}
