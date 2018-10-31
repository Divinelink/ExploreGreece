package com.blue.visitgreece.reviews;

import java.util.ArrayList;

public interface ReviewsInteractor {

    void getReviews(OnReviewsFinishListener listener);

    void getFilteredReviews(OnReviewsFinishListener listener,int intFilterRating);

    interface OnReviewsFinishListener{

        void onSuccess(ArrayList<ReviewDomain> reviews);

        void onError();
    }
}
