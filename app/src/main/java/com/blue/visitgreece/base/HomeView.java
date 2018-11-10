package com.blue.visitgreece.base;

import com.blue.visitgreece.tourpackages.TourPackageUI;

import java.io.Serializable;

public interface HomeView extends Serializable{

    void addToursFragment(TourPackageUI tourPackageUI);

    void addSubmitReviewFragment(TourPackageUI tourPackageUI);

    void addReviewsFragment(TourPackageUI tourPackageUI);

    void addToursPackageFragment();

}
