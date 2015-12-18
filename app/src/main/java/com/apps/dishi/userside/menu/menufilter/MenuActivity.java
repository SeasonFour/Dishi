package com.apps.dishi.userside.menu.menufilter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.apps.dishi.R;
import com.apps.dishi.userside.UserMainActivity;
import com.apps.dishi.userside.UserPagerAdapter;
import com.apps.dishi.userside.userprofile.FavoriteMealAdapter;
import com.apps.dishi.userside.userprofile.UserSettingsActivity;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

//import com.rufflez.parseloginexample.R;

/**
 * Created by victor on 9/2/14.
 */
public class MenuActivity extends FragmentActivity implements View.OnClickListener{
    //    Favourite stuff
    ListView listView;
    private FavoriteMealAdapter favoritesAdapter;

    ViewPager pager;
    ArrayList<String> types;

    //    Guillotine Menu Items
    LinearLayout home;
    LinearLayout profile;
    LinearLayout settings;

    private static final long RIPPLE_DURATION = 250;


    @InjectView(R.id.main_menu_toolbar)
    Toolbar toolbar;
    @InjectView(R.id.root)
    FrameLayout root;
    @InjectView(R.id.content_hamburger)
    View contentHamburger;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu);
        ButterKnife.inject(this);

 //        getActionBar().setTitle("Andy's Pet Store");
        // Tab Layout for the Fragments on the Home activity
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Recommended"));
//        tabLayout.addTab(tabLayout.newTab().setText("Menu"));
        tabLayout.addTab(tabLayout.newTab().setText("Chefs"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final UserPagerAdapter userPagerAdapter = new UserPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(userPagerAdapter);
        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());

                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                }
        );

//        // Guillotine Menu Setup
//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setTitle(null);
//        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine_user, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();

        home = (LinearLayout) findViewById(R.id.home_group);
        home.setOnClickListener(this);
        profile = (LinearLayout) findViewById(R.id.profile_group);
        profile.setOnClickListener(this);
        settings = (LinearLayout) findViewById(R.id.settings_group);
        settings.setOnClickListener(this);

        pager = (ViewPager)findViewById(R.id.pager);
        final ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        types = new ArrayList<String>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("MealType");
        query.addAscendingOrder("Type");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null) {
                    for (ParseObject type : parseObjects) {
                        String petType = type.getString("Type");
                        types.add(petType);
                    }
                    pager.setAdapter(adapter);
                }
            }
        });

        favoritesAdapter = new FavoriteMealAdapter(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_group:
                Intent a = new Intent(this, UserMainActivity.class);
                startActivity(a);
                break;

            case R.id.profile_group:
                showFavorites();
                break;

            case R.id.settings_group:
                Intent c = new Intent(this, UserSettingsActivity.class);
                startActivity(c);
                break;
        }
    }
    private void showFavorites() {
        favoritesAdapter.loadObjects();
        listView.setAdapter(favoritesAdapter);   }

    private class ViewPagerFragmentAdapter extends FragmentPagerAdapter {
        public ViewPagerFragmentAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position){
            return PageFragment.create(position+1, types.get(position).toString());
        }

        @Override
        public int getCount(){
            return types.size();
        }

        @Override
        public CharSequence getPageTitle(int position){
            return types.get(position).toString();
        }
    }



}
