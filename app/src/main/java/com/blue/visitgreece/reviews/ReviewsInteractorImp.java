package com.blue.visitgreece.reviews;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReviewsInteractorImp implements ReviewsInteractor {


    @Override
    public void getReviews(OnReviewsFinishListener listener) {
        ArrayList reviews = mockData();
        listener.onSuccess(reviews);

    }

    @Override
    public void getFilteredReviews(OnReviewsFinishListener listener, int intFilterRating) {

    }


    private ArrayList<Review> mockData() {
        ArrayList<Review> reviews = new ArrayList<>();
        reviews.add(new Review("asd",5,"red","bad rating"));
        reviews.add(new Review("asd",6,"red","very bad rating"));
        reviews.add(new Review("asd",1,"red","good rating"));
        reviews.add(new Review("asd",5,"red","bad rating"));
        reviews.add(new Review("asd",2,"red","good rating"));
        reviews.add(new Review("asd",3,"blue","bad rating"));
        reviews.add(new Review("asd",5,"green","very good rating"));
        reviews.add(new Review("asd",5,"red","bad rating"));
        reviews.add(new Review("asd",3,"red","bad rating"));
        reviews.add(new Review("asd",5,"red","hmm rating"));
        reviews.add(new Review("asd",5,"red","bad rating"));
        reviews.add(new Review("asd",5,"red","good rating"));
        return reviews;
    }

}
