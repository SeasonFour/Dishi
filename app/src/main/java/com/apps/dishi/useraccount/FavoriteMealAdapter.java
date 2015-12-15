package com.apps.dishi.useraccount;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.dishi.R;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.Arrays;

/*
 * The FavoriteMealAdapter is an extension of ParseQueryAdapter
 * that has a custom layout for favorite meals, including a
 * bigger preview image, the meal's rating, and a "favorite"
 * star.
 */

/**
 * Created by djmosi on 12/10/15.
 */
public class FavoriteMealAdapter extends ParseQueryAdapter<Meal> {

    public FavoriteMealAdapter(Context context) {
        super(context, new ParseQueryAdapter.QueryFactory<Meal>() {
            public ParseQuery<Meal> create() {
                // Here we can configure a ParseQuery to display
                // only top-rated meals.
                ParseQuery query = new ParseQuery("Meal");
                query.whereContainedIn("rating", Arrays.asList("5", "4"));
                query.orderByDescending("rating");
                return query;
            }
        });
    }

    @Override
    public View getItemView(Meal meal, View v, ViewGroup parent) {

        if (v == null) {
            v = View.inflate(getContext(), R.layout.list_favourites, null);
        }

        super.getItemView(meal, v, parent);

        ParseImageView mealImage = (ParseImageView) v.findViewById(R.id.food_icon);
        ParseFile photoFile = meal.getParseFile("photo");
        if (photoFile != null) {
            mealImage.setParseFile(photoFile);
            mealImage.loadInBackground(new GetDataCallback() {
                @Override
                public void done(byte[] data, ParseException e) {
                    // nothing to do
                }
            });
        }

        TextView titleTextView = (TextView) v.findViewById(R.id.title);
        titleTextView.setText(meal.getTitle());
        TextView ratingTextView = (TextView) v
                .findViewById(R.id.favorite_meal_rating);
        ratingTextView.setText(meal.getRating());
        return v;
    }

}
