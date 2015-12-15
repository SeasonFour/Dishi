package com.apps.dishi.useraccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.apps.dishi.R;
import com.apps.dishi.UserMainActivity;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class UserProfileActivity extends AppCompatActivity implements View.OnClickListener {

    //    Guillotine Menu Items
    LinearLayout home;
    LinearLayout profile;
    LinearLayout settings;

    private static final long RIPPLE_DURATION = 250;


    @InjectView(R.id.profile_toolbar)
    Toolbar toolbar;
    @InjectView(R.id.root)
    FrameLayout root;
    @InjectView(R.id.content_hamburger)
    View contentHamburger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.inject(this);

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
