package com.bns.camamsaotruc.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.bns.camamsaotruc.fragment.nav.HomeFragment;
import com.bns.camamsaotruc.fragment.nav.MetronomeFragment;
import com.bns.camamsaotruc.fragment.nav.SettingFragment;
import com.bns.camamsaotruc.fragment.nav.TunerFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new TunerFragment();
            case 2:
                return new MetronomeFragment();
            case 3:
                return new SettingFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
