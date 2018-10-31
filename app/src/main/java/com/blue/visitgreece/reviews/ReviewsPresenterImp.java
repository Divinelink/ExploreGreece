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
        interactor.getFilteredReviews(this,ratingFilter);
    }


    @Override
    public void onSuccess(ArrayList<ReviewDomain> reviews) {
        ArrayList<ReviewUI>  reviewsUI = new ArrayList<>();
        if(reviews != null && !reviews.isEmpty()){
            for(ReviewDomain review : reviews){
                ReviewUI reviewUI = new ReviewUI(
                        review.getId(),
                        review.getRating(),
                        review.getRatingColor(),
                        review.getComment()

                );
            }
        }
        reviewsView.showReviews(reviews);
    }

    @Override
    public void onError() {
        reviewsView.showGeneralError();

    }
}
