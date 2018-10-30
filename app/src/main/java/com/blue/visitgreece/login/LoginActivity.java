package com.blue.visitgreece.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blue.visitgreece.R;
<<<<<<< HEAD
import com.blue.visitgreece.reviews.ReviewsFragment;
=======
import com.blue.visitgreece.base.HomeView;
import com.blue.visitgreece.tourpackages.TourpackageUI;
import com.blue.visitgreece.tourpackages.TourspackagesFragment;
import com.blue.visitgreece.tours.ToursFragment;
>>>>>>> development


public class LoginActivity extends AppCompatActivity implements HomeView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

<<<<<<< HEAD

        //temporary , must get delete when we merge packages and set proper fragments for app flow
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_login_root, new ReviewsFragment())
                .commit();

=======
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.login_root, new LoginFragment())
//                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.login_root, new TourspackagesFragment().newInstance(this))
                .commit();

    }


    @Override
    public void addToursFragment(TourpackageUI tourpackageUI) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_root, ToursFragment.newInstance(tourpackageUI))
                .addToBackStack(null)
                .commit();
>>>>>>> development
    }

}

