package com.apps.dishi.userside.menu.menufilter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.dishi.R;
import com.apps.dishi.data.Meal;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
//import com.rufflez.parseloginexample.Pets;
//import com.rufflez.parseloginexample.R;

/**
 * Created by rufflez on 9/2/14.
 */
public class PageFragment extends ListFragment {

    private CustomParseQueryAdapter mAdapter;
    public static final String ARG_PAGE = "ARG_PAGE";
    private String pettype;

    public static PageFragment create(int page, String type){
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        args.putString("type", type);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        pettype = getArguments().getString("type");
        this.setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.page_fragment, container, false);
        mAdapter = new CustomParseQueryAdapter(getActivity());
        setListAdapter(mAdapter);
        mAdapter.loadObjects();
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    public class CustomParseQueryAdapter extends ParseQueryAdapter<Meal> {
        public CustomParseQueryAdapter(Context context){
            super(context, new QueryFactory<Meal>(){
                public ParseQuery create(){
                    ParseQuery query = new ParseQuery("Meal");
                    query.whereEqualTo("Type", pettype);
                    return query;
                }
            });
        }

        @Override
        public View getItemView(Meal pet, View v, ViewGroup parent){
            if (v == null){
                v = View.inflate(getContext(), R.layout.pets_with_photo, null);
            }

            super.getItemView(pet, v, parent);

            ParseImageView petImage = (ParseImageView)v.findViewById(R.id.petImage);
            ParseFile imageFile = pet.getPhotoFile();
            if (imageFile != null){
                petImage.setParseFile(imageFile);
                petImage.loadInBackground();
            }


            TextView petName = (TextView)v.findViewById(R.id.petName);
            petName.setText(pet.getString("Name"));


            TextView petBreed = (TextView)v.findViewById(R.id.petBreed);
            petBreed.setText(pet.getString("Breed"));

            return v;
        }
    }
}
