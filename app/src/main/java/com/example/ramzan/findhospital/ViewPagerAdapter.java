package com.example.ramzan.findhospital;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentlist= new ArrayList<>();
    private final List<String> fragmenttitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override

    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmenttitle.get(position);
    }

    @Override
    public int getCount() {
        return fragmenttitle.size();
    }

    public void addFragment(Fragment fragment, String title){
        fragmentlist.add(fragment);
        fragmenttitle.add(title);
    }
}
