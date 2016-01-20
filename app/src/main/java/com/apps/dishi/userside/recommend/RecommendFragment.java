package com.apps.dishi.userside.recommend;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.apps.dishi.R;
import com.apps.dishi.userside.checkout.CheckoutActivity;

public class RecommendFragment extends Fragment implements View.OnClickListener {
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend_fragment, container, false);

        Button Order1 = (Button) view.findViewById(R.id.order_button);
        Order1.setOnClickListener(this);

        Button Order2 = (Button) view.findViewById(R.id.order_button1);
        Order2.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_button:
                Intent a = new Intent(getActivity(), CheckoutActivity.class);
                startActivity(a);
                break;

            case R.id.order_button1:
                Intent b = new Intent(getActivity(), CheckoutActivity.class);
                startActivity(b);
                break;

        }
    }
}
