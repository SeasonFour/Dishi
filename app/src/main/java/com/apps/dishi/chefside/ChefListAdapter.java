package com.apps.dishi.chefside;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.dishi.R;
import com.parse.ParseException;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

/**
 * Created by iWanjugu on 17/12/2015.
 */
class ChefListAdapter extends ParseQueryAdapter<ParseObject> {

    public Context context;

    public ChefListAdapter(Context c) {
        super(c, new QueryFactory<ParseObject>() {
            @Override
            public ParseQuery<ParseObject> create() {

                ParseQuery<ParseObject> queryMenu = ParseQuery.getQuery("Meal");
                queryMenu = queryMenu.whereExists("title");
                queryMenu = queryMenu.whereExists("photo");
                queryMenu.setLimit(10);

                try {
                    queryMenu.find();
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return queryMenu;
            }
        });
        this.context = c;
    }
    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {
        if (null == v) {
            v = View.inflate(getContext(), R.layout.chef_list_view, null);
        }
        super.getItemView(object, v, parent);

        ParseImageView photo = (ParseImageView) v.findViewById(R.id.food_icon);
        TextView title = (TextView) v.findViewById(R.id.meal_name);

        photo.setParseFile(object.getParseFile("photo"));
        title.setText(object.getString("title"));

        return v;

    }


}
