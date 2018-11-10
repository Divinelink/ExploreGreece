package com.blue.visitgreece.reviews;

import android.content.Context;

import com.blue.visitgreece.tourpackages.TourPackageUI;

import java.util.ArrayList;

public interface ReviewsInteractor {

    void getReviews(OnReviewsFinishListener listener, Context ctx, TourPackageUI tourPackageUI, Boolean refresh);

    void getFilteredReviews(OnReviewsFinishListener listener,int intFilterRating);

    interface OnReviewsFinishListener{

        void onSuccess(ArrayList<ReviewDomain> reviews);

        void onError();
    }
}
