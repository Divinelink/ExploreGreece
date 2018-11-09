package com.blue.visitgreece.submitreviews;


import android.content.Context;
import android.view.View;

import com.blue.visitgreece.tourpackages.TourpackageUI;

public interface SubmitReviewPresenter {

    void submitReview(TourpackageUI tourPackageUI, Context ctx, String reviewText, int reviewRating, String username);

    void stylize(TourpackageUI tourPackageUI, View view);

}
