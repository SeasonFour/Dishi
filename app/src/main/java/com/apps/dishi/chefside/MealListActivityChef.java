package com.apps.dishi.chefside;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.apps.dishi.R;

public class MealListActivityChef extends AppCompatActivity {

    ListView listView;
//    private ParseQueryAdapter mainAdapter;
    private ChefListAdapter chefListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chef_side_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.chef_menu_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.fab: {
                        newMeal();
                        break;
                    }
                }

            }
        });

//        listView = (ListView) findViewById(R.id.chef_list);
//        listView.setClickable(true);
//
//        mainAdapter = new ParseQueryAdapter<>(this, Meal.class, R.layout.chef_list_view);
//        mainAdapter.setTextKey("title");
//        mainAdapter.setImageKey("photo");
//
//        // Default view is all meals
//        listView.setAdapter(mainAdapter);

        //Using the custom adapter

        chefListAdapter = new ChefListAdapter(this);
        chefListAdapter.loadObjects();
        listView = (ListView) findViewById(R.id.chef_list);
        listView.setClickable(true);

//        chefListAdapter.setTextKey("title");
//        chefListAdapter.setImageKey("photo");

        listView.setAdapter(chefListAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chef_menu_layout, menu);
        return true;
    }

    /*
     * Posting meals and refreshing the list will be controlled from the Action
     * Bar.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_refresh: {
                updateMealList();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateMealList() {
        chefListAdapter.loadObjects();
        listView.setAdapter(chefListAdapter);
    }

    private void newMeal() {
        Intent i = new Intent(this, NewMealActivity.class);
        startActivityForResult(i, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            // If a new post has been added, update
            // the list of posts
            updateMealList();
        }
    }

}
