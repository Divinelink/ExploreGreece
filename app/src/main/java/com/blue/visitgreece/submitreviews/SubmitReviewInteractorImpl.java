package com.blue.visitgreece.submitreviews;

import android.content.Context;
import android.os.AsyncTask;

import com.blue.visitgreece.base.VisitGreeceDatabase;
import com.blue.visitgreece.rest.RestClient;
import com.blue.visitgreece.reviews.ReviewDomain;
import com.blue.visitgreece.tourpackages.TourPackageUI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitReviewInteractorImpl implements SubmitReviewInteractor {

    @Override
    public void submitReview(final OnSubmitReviewFinishListener listener,
                             final Context ctx,
                             final TourPackageUI tourPackageUI,
                             final String reviewText,
                             final int reviewRating,
                             final String username) {


        final ReviewDomain reviewDomain = new ReviewDomain(tourPackageUI.getId(),
                reviewRating,
                reviewText,
                username); // get user's username

        final SubmitReviewsDao submitReviewsDao = VisitGreeceDatabase.getDatabase(ctx).submitReviewsDao();

        Call<Void> call = RestClient.call().postReview(reviewDomain, tourPackageUI.getId());

        if (reviewDomain.getScore() != 0) {
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {

                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {

                            if (reviewDomain.getScore() != 0) {
                                submitReviewsDao.deleteByUsername(reviewDomain.getUsername());
                                submitReviewsDao.submitReviewToDB(reviewDomain);
                                listener.onSuccess();
                            }
                        }
                    });
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    listener.onError();
                }
            });
        }
        else {
            listener.onNoRatingEntered();
        }


    }
}
