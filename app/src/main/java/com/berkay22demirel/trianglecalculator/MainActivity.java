package com.berkay22demirel.trianglecalculator;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.berkay22demirel.trianglecalculator.adapters.FragmentAdapter;
import com.berkay22demirel.trianglecalculator.fragments.HomepageFragment;
import com.berkay22demirel.trianglecalculator.fragments.ResultsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mNavigationView;
    private ViewPager mViewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_homepage:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_results:
                    mViewPager.setCurrentItem(1);
                    return true;
            }
            return false;
        }
    };

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mNavigationView.setSelectedItemId(R.id.navigation_homepage);
                    break;
                case 1:
                    mNavigationView.setSelectedItemId(R.id.navigation_results);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mViewPager = findViewById(R.id.main_activity_view_pager);
        mNavigationView = findViewById(R.id.main_activity_bottom_navigation_view);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        mNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager.setAdapter(getFragmentAdapter());
        mViewPager.setCurrentItem(0);
    }

    private FragmentAdapter getFragmentAdapter() {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.add(new HomepageFragment(), getString(R.string.menu_homepage));
        adapter.add(new ResultsFragment(), getString(R.string.menu_results));
        return adapter;
    }
}
