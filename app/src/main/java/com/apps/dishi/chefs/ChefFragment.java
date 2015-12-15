package com.apps.dishi.chefs;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.apps.dishi.R;

public class ChefFragment extends Fragment implements View.OnClickListener {
    @Nullable


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chef_fragment, container, false);
        ImageView ChefPhoto = (ImageView) view.findViewById(R.id.chef_image);
        ChefPhoto.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chef_image:
                Intent a = new Intent(getActivity(), Chefs.class);
                startActivity(a);
                break;

        }
    }
}


