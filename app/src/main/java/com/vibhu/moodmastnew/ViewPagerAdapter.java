package com.vibhu.moodmastnew;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SeasideFragment();
            case 1:
                return new CityFragment();
            case 2:
                return new JungleFragment();
            case 3:
                return new CountrysideFragment();
            case 4:
                return new AsiaFragment();
        }
        return null;
    }


    @Override
    public int getCount() {
        return 5;
    }
}