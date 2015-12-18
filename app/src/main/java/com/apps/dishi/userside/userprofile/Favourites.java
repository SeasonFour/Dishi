package com.apps.dishi.userside.userprofile;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

import com.apps.dishi.R;
import com.apps.dishi.chefside.NewMealActivity;
import com.apps.dishi.data.Meal;
import com.parse.ParseQueryAdapter;

public class Favourites extends ListActivity {

    private ParseQueryAdapter<Meal> mainAdapter;
    private FavoriteMealAdapter favoritesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         // Subclass of ParseQueryAdapter
        favoritesAdapter = new FavoriteMealAdapter(this);

        // Default view is all meals
        setListAdapter(mainAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_meal_list, menu);
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

            case R.id.action_favorites: {
                showFavorites();
                break;
            }

            case R.id.action_new: {
                newMeal();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateMealList() {
        mainAdapter.loadObjects();
        setListAdapter(mainAdapter);
    }

    private void showFavorites() {
        favoritesAdapter.loadObjects();
        setListAdapter(favoritesAdapter);
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

