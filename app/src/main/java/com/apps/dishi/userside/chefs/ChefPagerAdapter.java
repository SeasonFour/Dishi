package com.apps.dishi.userside.chefs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by iWanjugu on 15/12/2015.
 */
public class ChefPagerAdapter extends FragmentStatePagerAdapter {

    int mnumOfTabs;
    public ChefPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mnumOfTabs = NumOfTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChefAboutFragment();
            case 1:
                return new ChefDishesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount () {
        return mnumOfTabs;
    }
}
