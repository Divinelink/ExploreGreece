package com.blue.visitgreece.base;

import com.blue.visitgreece.login.LoginFragment;
import com.blue.visitgreece.login.LoginUI;
import com.blue.visitgreece.tourpackages.TourpackageUI;

import java.io.Serializable;

public interface HomeView extends Serializable{
    void addToursFragment(TourpackageUI tourpackageUI);
    void addReviewsFragment(TourpackageUI tourpackageUI);
    void addToursPackageFragment();
}
