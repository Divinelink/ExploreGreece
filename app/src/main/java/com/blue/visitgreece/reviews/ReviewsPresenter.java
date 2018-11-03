package com.blue.visitgreece.reviews;

import android.content.Context;

import com.blue.visitgreece.tourpackages.TourpackageUI;

public interface ReviewsPresenter {

    void getReviews(Context ctx, TourpackageUI tourpackageUI,Boolean refresh);

    void getFilteredReviews(int ratingFilter);

}
