package com.blue.visitgreece.submitreviews;


import android.content.Context;
import android.view.View;

import com.blue.visitgreece.tourpackages.TourPackageUI;

public interface SubmitReviewPresenter {

    void submitReview(TourPackageUI tourPackageUI, Context ctx, String reviewText, int reviewRating, String username);

    void stylize(TourPackageUI tourPackageUI, View view);

}
