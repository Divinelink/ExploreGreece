package com.blue.visitgreece.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blue.visitgreece.R;
import com.blue.visitgreece.login.LoginFragment;

import com.blue.visitgreece.reviews.ReviewsFragment;
import com.blue.visitgreece.submitreviews.SubmitReviewFragment;
import com.blue.visitgreece.tourpackages.TourpackageUI;
import com.blue.visitgreece.tourpackages.TourspackagesFragment;
import com.blue.visitgreece.tours.ToursFragment;


public class LoginActivity extends AppCompatActivity implements HomeView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.login_root,  LoginFragment.newInstance(this))
                .commit();
    }


    @Override
    public void addToursPackageFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_root, TourspackagesFragment.newInstance(this))
                .commit();
    }


    @Override
    public void addSubmitReviewFragment(TourpackageUI tourpackageUI) {
        getSupportFragmentManager()
                .beginTransaction()
//                .replace(R.id.login_root, SubmitReviewFragment().newInstance())  //add submit review
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void addToursFragment(TourpackageUI tourpackageUI) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_root, ToursFragment.newInstance(tourpackageUI,this))
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void addReviewsFragment(TourpackageUI tourpackageUI) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_root, ReviewsFragment.newInstance(tourpackageUI))
                .addToBackStack(null)
                .commit();

    }

}
