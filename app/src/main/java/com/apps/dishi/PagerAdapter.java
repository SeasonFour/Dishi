package com.apps.dishi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.apps.dishi.chefs.ChefFragment;
import com.apps.dishi.menu.MenuFragment;
import com.apps.dishi.recommend.RecommendFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mnumOfTabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mnumOfTabs = NumOfTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RecommendFragment();
            case 1:
                return new MenuFragment();
            case 2:
                return new ChefFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount () {
        return mnumOfTabs;
    }
}

