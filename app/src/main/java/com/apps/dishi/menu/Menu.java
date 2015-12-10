package com.apps.dishi.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.apps.dishi.R;
import com.apps.dishi.chefs.Chefs;
import com.apps.dishi.recommend.RecommendedLayout;

public class Menu extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu);

        Button ToChefs = (Button)findViewById(R.id.menu_to_chefs);
        ToChefs.setOnClickListener(this);

        // Creating on click change activities for a button
        Button ToRecommend = (Button)findViewById(R.id.menu_to_recommend);
        ToRecommend.setOnClickListener(this);
    }

    private void toChefsClick ()
    {
        Intent a = new Intent(Menu.this, Chefs.class);
        startActivity(a);
    }
    private void toRecommendedLayoutClick ()
    {
        Intent b = new Intent(Menu.this, RecommendedLayout.class);
        startActivity(b);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_to_chefs:
                toChefsClick();
                break;

            case R.id.menu_to_recommend:
                toRecommendedLayoutClick();
                break;
        }
    }
}