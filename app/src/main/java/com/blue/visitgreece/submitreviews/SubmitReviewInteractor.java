package com.blue.visitgreece.submitreviews;

import android.content.Context;

import com.blue.visitgreece.tourpackages.TourpackageUI;


public interface SubmitReviewInteractor {

    void submitReview(OnSubmitReviewFinishListener listener,
                      Context ctx,
                      TourpackageUI tourpackageUI,
                      String reviewText,
                      int reviewRating,
                      String username);

    interface OnSubmitReviewFinishListener{

        void onSuccess();

        void onError();

        void onNoRatingEntered();

    }
}
