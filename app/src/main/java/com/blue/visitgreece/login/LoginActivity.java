package com.blue.visitgreece.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blue.visitgreece.R;
import com.blue.visitgreece.tours.ToursFragment;

import timber.log.Timber;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String tourpackageId = getIntent().getStringExtra("tourpackageId");
        Timber.e("The tour package Id:"+ tourpackageId);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.login_root, new ToursFragment()) //μια activity
                .commit();
    }
}
