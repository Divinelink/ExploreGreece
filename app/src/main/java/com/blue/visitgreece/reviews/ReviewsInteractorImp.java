package com.blue.visitgreece.reviews;

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
