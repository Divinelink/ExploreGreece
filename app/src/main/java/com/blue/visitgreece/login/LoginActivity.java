package com.blue.visitgreece.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blue.visitgreece.R;
import com.blue.visitgreece.reviews.ReviewsFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //temporary , must get delete when we merge packages and set proper fragments for app flow
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_login_root, new ReviewsFragment())
                .commit();

    }

}

