package com.blue.visitgreece.reviews;

import android.content.Context;

import com.blue.visitgreece.tourpackages.TourPackageUI;

public interface ReviewsPresenter {

    void getReviews(Context ctx, TourPackageUI tourPackageUI, Boolean refresh);

    void getFilteredReviews(int ratingFilter);

}
