package com.apps.dishi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Recommended extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recommended);

        Button LoginButton = (Button)findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(this);

        // Creating on click change activities for a button
        Button googleButton = (Button)findViewById(R.id.GoogleButton);
        googleButton.setOnClickListener(this);

        Button twitterButton = (Button)findViewById(R.id.TwitterButton);
        twitterButton.setOnClickListener(this);

        Button facebookButton = (Button)findViewById(R.id.FacebookButton);
        facebookButton.setOnClickListener(this);

    }

    private void toRecommendedLayoutClick ()
    {
        Intent a = new Intent(Recommended.this, RecommendedLayout.class);
        startActivity(a);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.GoogleButton:
                toRecommendedLayoutClick();
                break;

            case R.id.TwitterButton:
                toRecommendedLayoutClick();
                break;

            case R.id.FacebookButton:
                toRecommendedLayoutClick();
                break;

            case R.id.LoginButton:
                toRecommendedLayoutClick();
                break;
        }

    }
}
