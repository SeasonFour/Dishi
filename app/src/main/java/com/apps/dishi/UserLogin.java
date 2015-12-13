package com.apps.dishi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.apps.dishi.useraccount.MealListActivity;

public class UserLogin extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_layout);

        Button LoginButton = (Button)findViewById(R.id.eater_login_button);
        LoginButton.setOnClickListener(this);

        // Creating on click change activities for a button
        Button googleButton = (Button)findViewById(R.id.eater_google_button);
        googleButton.setOnClickListener(this);

        Button twitterButton = (Button)findViewById(R.id.eater_twitter_button);
        twitterButton.setOnClickListener(this);

        Button facebookButton = (Button)findViewById(R.id.eater_facebook_button);
        facebookButton.setOnClickListener(this);

    }

    private void toRecommendedLayoutClick ()
    {
        Intent a = new Intent(UserLogin.this, MealListActivity.class);
        startActivity(a);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.eater_google_button:
                toRecommendedLayoutClick();
                break;

            case R.id.eater_twitter_button:
                toRecommendedLayoutClick();
                break;

            case R.id.eater_facebook_button:
                toRecommendedLayoutClick();
                break;

            case R.id.eater_login_button:
                toRecommendedLayoutClick();
                break;
        }

    }
}
