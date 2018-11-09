package com.blue.visitgreece.submitreviews;

import android.content.Context;

import com.blue.visitgreece.base.VisitGreeceDatabase;
import com.blue.visitgreece.rest.RestClient;
import com.blue.visitgreece.reviews.ReviewDomain;
import com.blue.visitgreece.tourpackages.TourpackageUI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitReviewInteractorImpl implements SubmitReviewInteractor {

    @Override
    public void submitReview(final OnSubmitReviewFinishListener listener,
                             final Context ctx,
                             final TourpackageUI tourpackageUI,
                             final String reviewText,
                             final int reviewRating,
                             final String username) {


        final ReviewDomain reviewDomain = new ReviewDomain(tourpackageUI.getId(),
                reviewRating,
                reviewText,
                username); // get user's username

        final SubmitReviewsDao submitReviewsDao = VisitGreeceDatabase.getDatabase(ctx).submitReviewsDao();



////FIXME call always goes to onFailure even though the review is posted

        Call<SubmitReviewDomain> call = RestClient.call().postReview(reviewDomain, tourpackageUI.getId());
        call.enqueue(new Callback<SubmitReviewDomain>() {
            @Override
            public void onResponse(Call<SubmitReviewDomain> call, final Response<SubmitReviewDomain> response) {
                listener.onSuccess();
            }

            @Override
            public void onFailure(Call<SubmitReviewDomain> call, Throwable t) {
                listener.onError();
            }
        });
    }
}
