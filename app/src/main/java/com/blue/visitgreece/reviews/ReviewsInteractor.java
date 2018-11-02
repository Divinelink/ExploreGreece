package com.blue.visitgreece.reviews;

import android.content.Context;

import java.util.ArrayList;

public interface ReviewsInteractor {

    void getReviews(OnReviewsFinishListener listener, Context ctx);

    void getFilteredReviews(OnReviewsFinishListener listener,int intFilterRating);

    interface OnReviewsFinishListener{

        void onSuccess(ArrayList<ReviewDomain> reviews);

        void onError();
    }
}
