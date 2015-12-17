package com.apps.dishi.chefside;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.apps.dishi.R;

public class ChefLogin extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chef_login);

        Button chefLoginButton = (Button)findViewById(R.id.chef_login_button);
        chefLoginButton.setOnClickListener(this);
    }

    private void toMealListClick ()
    {
        Intent a = new Intent(this, MealListActivityChef.class);
        startActivity(a);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chef_login_button:
                toMealListClick();
                break;
        }
    }
}
