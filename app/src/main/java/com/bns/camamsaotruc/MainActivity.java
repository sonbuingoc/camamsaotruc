package com.bns.camamsaotruc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bns.camamsaotruc.adapter.MyViewPagerAdapter;
import com.bns.camamsaotruc.transformer.ZoomOutPageTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        initListener();
    }

    private void initUi() {
        bottomNav = findViewById(R.id.bottom_nav);
        viewPager2 = findViewById(R.id.view_pager2);
        viewPager2.setPageTransformer(new ZoomOutPageTransformer());
        myViewPagerAdapter = new MyViewPagerAdapter(this);
        viewPager2.setAdapter(myViewPagerAdapter);
    }

    private void initListener() {
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onSelectItemNav(item);
                return true;
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                onPageChangeSelected(position);
            }
        });
    }

    private void onPageChangeSelected(int position) {
        switch (position){
            case 0:
                bottomNav.getMenu().findItem(R.id.action_home).setChecked(true);
                break;
            case 1:
                bottomNav.getMenu().findItem(R.id.action_tuner).setChecked(true);
                break;
            case 2:
                bottomNav.getMenu().findItem(R.id.action_metronome).setChecked(true);
                break;
            case 3:
                bottomNav.getMenu().findItem(R.id.action_setting).setChecked(true);
                break;
        }
    }

    private void onSelectItemNav(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_home:
                viewPager2.setCurrentItem(0);
                break;
            case R.id.action_tuner:
                viewPager2.setCurrentItem(1);
                break;
            case R.id.action_metronome:
                viewPager2.setCurrentItem(2);
                break;
            case R.id.action_setting:
                viewPager2.setCurrentItem(3);
                break;
        }
    }
}