package com.blue.visitgreece.submitreviews;

import android.content.Context;
import android.os.AsyncTask;

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

        Call<Void> call = RestClient.call().postReview(reviewDomain, tourpackageUI.getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {

                        if (reviewDomain.getScore() != 0) {
                            listener.onSuccess();
                            submitReviewsDao.submitReviewToDB(reviewDomain);
                            //FIXME should replace current review in DB if it exists with the new one.
                        }
                        else
                            listener.onNoRatingEntered();
                    }
                });
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onError();
            }
        });


    }
}
