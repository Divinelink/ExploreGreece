package com.blue.visitgreece.reviews;

import java.util.ArrayList;

public class ReviewsPresenterImp implements ReviewsPresenter ,ReviewsInteractor.OnReviewsFinishListener{

    ReviewsView reviewsView;
    ReviewsInteractor interactor;


    public ReviewsPresenterImp(ReviewsView reviewsView) {
        this.reviewsView = reviewsView;
        interactor = new  ReviewsInteractorImp();
    }

    @Override
    public void getReviews() {
        interactor.getReviews(this);
    }

    @Override
    public void getFilteredReviews(int ratingFilter){

    }


    @Override
    public void onSuccess(ArrayList<Review> reviews) {
        reviewsView.showReviews(reviews);
    }

    @Override
    public void onError() {

    }
}
