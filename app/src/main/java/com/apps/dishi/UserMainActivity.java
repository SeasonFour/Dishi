package com.apps.dishi;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.apps.dishi.useraccount.UserProfileActivity;
import com.apps.dishi.useraccount.UserSettingsActivity;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class UserMainActivity extends AppCompatActivity implements View.OnClickListener {

//    Guillotine Menu Items
    LinearLayout home;
    LinearLayout profile;
    LinearLayout settings;

    private static final long RIPPLE_DURATION = 250;


    @InjectView(R.id.user_guillotine_toolbar)
    Toolbar toolbar;
    @InjectView(R.id.root)
    FrameLayout root;
    @InjectView(R.id.content_hamburger)
    View contentHamburger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_side_main);
        ButterKnife.inject(this);

        // Tab Layout for the Fragments on the Home activity
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Recommended"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu"));
        tabLayout.addTab(tabLayout.newTab().setText("Chefs"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final UserPagerAdapter adapter = new UserPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
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

        // Guillotine Menu Setup
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

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
    }

            @Override
            public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.home_group:
                    Intent a = new Intent(this, UserMainActivity.class);
                    startActivity(a);
                    break;

                case R.id.profile_group:
                    Intent b = new Intent(this, UserProfileActivity.class);
                    startActivity(b);
                    break;

                case R.id.settings_group:
                    Intent c = new Intent(this, UserSettingsActivity.class);
                    startActivity(c);
                    break;
            }

        }


   }

