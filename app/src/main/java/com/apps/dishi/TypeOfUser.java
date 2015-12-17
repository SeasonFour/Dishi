package com.apps.dishi;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.apps.dishi.chefside.ChefLogin;
import com.apps.dishi.userside.UserLogin;

public class TypeOfUser extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_of_user);

        Button EaterLoginButton = (Button)findViewById(R.id.eater_login);
        EaterLoginButton.setOnClickListener(this);

        Button ChefLoginButton = (Button)findViewById(R.id.chef_login);
        ChefLoginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.eater_login:
                Intent a = new Intent(this, UserLogin.class);
                startActivity(a);
                break;

            case R.id.chef_login:
                Intent b = new Intent(this, ChefLogin.class);
                startActivity(b);
                break;

        }
    }
}
