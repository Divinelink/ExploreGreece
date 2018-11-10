package com.blue.visitgreece.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blue.visitgreece.R;
import com.blue.visitgreece.login.LoginFragment;

import com.blue.visitgreece.reviews.ReviewsFragment;
import com.blue.visitgreece.submitreviews.SubmitReviewFragment;
import com.blue.visitgreece.tourpackages.TourPackageUI;
import com.blue.visitgreece.tourpackages.ToursPackagesFragment;
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
                .replace(R.id.login_root, ToursPackagesFragment.newInstance(this))
                .commit();
    }


    @Override
    public void addSubmitReviewFragment(TourPackageUI tourPackageUI) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_root, SubmitReviewFragment.newInstance(tourPackageUI))  //add submit review
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void addToursFragment(TourPackageUI tourPackageUI) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_root, ToursFragment.newInstance(tourPackageUI,this))
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void addReviewsFragment(TourPackageUI tourPackageUI) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_root, ReviewsFragment.newInstance(tourPackageUI))
                .addToBackStack(null)
                .commit();

    }

}
