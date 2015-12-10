package com.apps.dishi.recommend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.apps.dishi.R;
import com.apps.dishi.chefs.Chefs;
import com.apps.dishi.menu.Menu;

public class RecommendedLayout extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recommended_layout);

        Button ToChefs = (Button)findViewById(R.id.recommend_to_chefs);
        ToChefs.setOnClickListener(this);

        // Creating on click change activities for a button
        Button ToMenu= (Button)findViewById(R.id.recommend_to_menu);
        ToMenu.setOnClickListener(this);
    }

    private void RecLaytoChefsClick ()
    {
        Intent a = new Intent(this, Chefs.class);
        startActivity(a);
    }
    private void RecLaytoMenuClick ()
    {
//        Toast.makeText(this,"reached here", Toast.LENGTH_SHORT ).show();
        Intent b = new Intent(this, Menu.class);
        startActivity(b);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recommend_to_chefs:
                RecLaytoChefsClick();
                break;

            case R.id.recommend_to_menu:
                RecLaytoMenuClick();
                break;
        }
    }
}
