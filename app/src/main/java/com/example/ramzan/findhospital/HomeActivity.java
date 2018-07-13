package com.example.ramzan.findhospital;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ramzan.findhospital.Hospital.HospitalFragment;
import com.example.ramzan.findhospital.Map.MapFragment;
import com.example.ramzan.findhospital.Pharmecy.PharmecyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {


    private ActionBar actionBar;

    private ViewPagerAdapter pagerAdapter;

    @BindView(R.id.tlb)
    Toolbar tlb;
    @BindView(R.id.tab_help_header)
    TabLayout tabLayout;
    @BindView(R.id.viewpager_help)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(tlb);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Health Care");


        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new HospitalFragment(), "Hospital");
        pagerAdapter.addFragment(new PharmecyFragment(), "Pharmecy");
        pagerAdapter.addFragment(new MapFragment(), "Map");
        pager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(pager);


    }

}
