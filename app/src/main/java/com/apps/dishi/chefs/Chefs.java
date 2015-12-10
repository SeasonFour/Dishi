package com.apps.dishi.chefs;

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
import com.apps.dishi.menu.Menu;
import com.apps.dishi.recommend.RecommendedLayout;

public class Chefs extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_chefs);

        Button ToMenu = (Button)findViewById(R.id.chef_to_menu);
        ToMenu.setOnClickListener(this);

        // Creating on click change activities for a button
        Button ToRecommend = (Button)findViewById(R.id.chef_to_recommend);
        ToRecommend.setOnClickListener(this);
    }

    private void ChefstoMenuClick ()
    {
        Intent a = new Intent(Chefs.this, Menu.class);
        startActivity(a);
    }
    private void ChefstoRecommendedLayoutClick ()
    {
        Intent b = new Intent(Chefs.this, RecommendedLayout.class);
        startActivity(b);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chef_to_menu:
                ChefstoMenuClick();
                break;

            case R.id.chef_to_recommend:
                ChefstoRecommendedLayoutClick();
                break;
        }
    }
}
