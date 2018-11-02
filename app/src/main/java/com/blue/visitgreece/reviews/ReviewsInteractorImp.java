package com.blue.visitgreece.reviews;

import com.blue.visitgreece.rest.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ReviewsInteractorImp implements ReviewsInteractor {


    @Override
    public void getReviews(final OnReviewsFinishListener listener) {
//        ArrayList reviews = mockData();
        Call<ArrayList<ReviewDomain>> call = RestClient.call().fetchReviews("CH"); //to vazw karfwta prepei na to pernei apo to bundle apo to tours-christina
        call.enqueue(new Callback<ArrayList<ReviewDomain>>() {
            @Override
            public void onResponse(Call<ArrayList<ReviewDomain>> call, Response<ArrayList<ReviewDomain>> response) {
                try {
                    listener.onSuccess(response.body());
                }catch (Exception e){
                    onFailure(call,e);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ReviewDomain>> call, Throwable t) {
                Timber.e("failed to get reviews" );
                listener.onError();
            }
        });
//        listener.onSuccess(reviews);

    }

    @Override
    public void getFilteredReviews(final OnReviewsFinishListener listener, final int intFilterRating) {
        Call<ArrayList<ReviewDomain>> call = RestClient.call().fetchReviews("CH"); //to vazw karfwta prepei na to pernei apo to bundle apo to tours-christina
        call.enqueue(new Callback<ArrayList<ReviewDomain>>() {

            @Override
            public void onResponse(Call<ArrayList<ReviewDomain>> call, Response<ArrayList<ReviewDomain>> response) {

                ArrayList<ReviewDomain> filteredReviewsList = new ArrayList<>();
                ArrayList<ReviewDomain> reviews = response.body();
                for(ReviewDomain filteredReview : reviews){
                    if(filteredReview.getScore() >= intFilterRating){
                        filteredReviewsList.add(filteredReview);
                    }

                }
                listener.onSuccess(filteredReviewsList);
            }

            @Override
            public void onFailure(Call<ArrayList<ReviewDomain>> call, Throwable t) {
                Timber.e("failed to get reviews" );
                listener.onError();
            }
        });
//        listener.onSuccess(reviews);

    }


    private ArrayList<ReviewDomain> mockData() {
        ArrayList<ReviewDomain> reviews = new ArrayList<ReviewDomain>();
        reviews.add(new ReviewDomain("asd",5,"red","bad rating"));
        reviews.add(new ReviewDomain("asd",6,"red","very bad rating"));
        reviews.add(new ReviewDomain("asd",1,"red","good rating"));
        reviews.add(new ReviewDomain("asd",5,"red","bad rating"));
        reviews.add(new ReviewDomain("asd",2,"red","good rating"));
        reviews.add(new ReviewDomain("asd",3,"blue","bad rating"));
        reviews.add(new ReviewDomain("asd",5,"green","very good rating"));
        reviews.add(new ReviewDomain("asd",5,"red","bad rating"));
        reviews.add(new ReviewDomain("asd",3,"red","bad rating"));
        reviews.add(new ReviewDomain("asd",5,"red","hmm rating"));
        reviews.add(new ReviewDomain("asd",5,"red","bad rating"));
        reviews.add(new ReviewDomain("asd",5,"red","good rating"));
        return reviews;
    }

}
