package com.blue.visitgreece.reviews;

import android.content.Context;
import android.os.AsyncTask;

import com.blue.visitgreece.base.VisitGreeceDatabase;
import com.blue.visitgreece.rest.RestClient;
import com.blue.visitgreece.tourpackages.TourPackageUI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ReviewsInteractorImp implements ReviewsInteractor {

    static TourPackageUI tourPackageUI;

    @Override
    public void getReviews(final OnReviewsFinishListener listener, final Context ctx, final TourPackageUI tourPackageUI, final Boolean refresh) {
//        ArrayList reviews = mockData();
        this.tourPackageUI = tourPackageUI;

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                final ReviewsDao reviewsDao = VisitGreeceDatabase.getDatabase(ctx).reviewsDao();

                List<ReviewDomain> reviewsFromDb = reviewsDao.getAllReviewsByID(tourPackageUI.getId());
                ArrayList<ReviewDomain> arrayListFromDb = new ArrayList<>();
                arrayListFromDb.addAll(reviewsFromDb);

//               listener.onSuccess(arrayListFromDb); //testing for db
                if (reviewsFromDb.isEmpty() || refresh) {
                    Call<ArrayList<ReviewDomain>> call = RestClient.call().fetchReviews(tourPackageUI.getId()); //to vazw karfwta prepei na to pernei apo to bundle apo to tours-christina
                    call.enqueue(new Callback<ArrayList<ReviewDomain>>() {
                        @Override
                        public void onResponse(final Call<ArrayList<ReviewDomain>> call, final Response<ArrayList<ReviewDomain>> response) {

                            try {
                                AsyncTask.execute(new Runnable() {
                                    @Override
                                    public void run() {

                                        ArrayList<ReviewDomain> reviewDomainArrayList = response.body();
                                        for (ReviewDomain r : reviewDomainArrayList) {
                                            r.setId(tourPackageUI.getId());
                                        }
                                        reviewsDao.updateReviews(reviewDomainArrayList);
                                        listener.onSuccess(response.body());
                                    }
                                });
                            } catch (Exception e) {
                                onFailure(call, e);
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<ReviewDomain>> call, Throwable t) {
                            Timber.e("failed to get reviews");
                            listener.onError();
                        }
                    });
                } else {
                    listener.onSuccess(arrayListFromDb);
                }//end if
            }
        });


//        listener.onSuccess(reviews); //mockdata
    }


    /*
     * filtered reviews does not communicate with database , it only filters results from the endpoint
      *
      * */
    @Override
    public void getFilteredReviews(final OnReviewsFinishListener listener, final int intFilterRating) {
        Call<ArrayList<ReviewDomain>> call = RestClient.call().fetchReviews(tourPackageUI.getId()); //to vazw karfwta prepei na to pernei apo to bundle apo to tours-christina
        call.enqueue(new Callback<ArrayList<ReviewDomain>>() {

            @Override
            public void onResponse(Call<ArrayList<ReviewDomain>> call, Response<ArrayList<ReviewDomain>> response) {

                ArrayList<ReviewDomain> filteredReviewsList = new ArrayList<>();
                ArrayList<ReviewDomain> reviews = response.body();
                for (ReviewDomain filteredReview : reviews) {
                    if (filteredReview.getScore() >= intFilterRating) {
                        filteredReviewsList.add(filteredReview);
                    }

                }
                listener.onSuccess(filteredReviewsList);
            }

            @Override
            public void onFailure(Call<ArrayList<ReviewDomain>> call, Throwable t) {
                Timber.e("failed to get reviews");
                listener.onError();
            }
        });
    }

//    private ArrayList<ReviewDomain> mockData() {
//        ArrayList<ReviewDomain> reviews = new ArrayList<ReviewDomain>();
//        reviews.add(new ReviewDomain("asd", 5, "red", "bad rating"));
//        reviews.add(new ReviewDomain("asd", 6, "red", "very bad rating"));
//        reviews.add(new ReviewDomain("asd", 1, "red", "good rating"));
//        reviews.add(new ReviewDomain("asd", 5, "red", "bad rating"));
//        reviews.add(new ReviewDomain("asd", 2, "red", "good rating"));
//        reviews.add(new ReviewDomain("asd", 3, "blue", "bad rating"));
//        reviews.add(new ReviewDomain("asd", 5, "green", "very good rating"));
//        reviews.add(new ReviewDomain("asd", 5, "red", "bad rating"));
//        reviews.add(new ReviewDomain("asd", 3, "red", "bad rating"));
//        reviews.add(new ReviewDomain("asd", 5, "red", "hmm rating"));
//        reviews.add(new ReviewDomain("asd", 5, "red", "bad rating"));
//        reviews.add(new ReviewDomain("asd", 5, "red", "good rating"));
//        return reviews;
//    }

}
