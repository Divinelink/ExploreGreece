package com.blue.visitgreece.reviews;

import android.content.Context;

import com.blue.visitgreece.tourpackages.TourpackageUI;

import java.util.ArrayList;

public interface ReviewsInteractor {

    void getReviews(OnReviewsFinishListener listener, Context ctx, TourpackageUI tourpackageUI, Boolean refresh);

    void getFilteredReviews(OnReviewsFinishListener listener,int intFilterRating);

    interface OnReviewsFinishListener{

        void onSuccess(ArrayList<ReviewDomain> reviews);

        void onError();
    }
}
