package com.blue.visitgreece.reviews;

import android.content.Context;

import com.blue.visitgreece.tourpackages.TourPackageUI;

import java.util.ArrayList;

public class ReviewsPresenterImp implements ReviewsPresenter ,ReviewsInteractor.OnReviewsFinishListener{

    ReviewsView reviewsView;
    ReviewsInteractor interactor;


    public ReviewsPresenterImp(ReviewsView reviewsView) {
        this.reviewsView = reviewsView;
        interactor = new  ReviewsInteractorImp();
    }

    @Override
    public void getReviews(Context ctx, TourPackageUI tourPackageUI, Boolean refresh) {
        interactor.getReviews(this, ctx, tourPackageUI, refresh);
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
                        review.getScore(),
                        review.getComment(),
                        review.getUsername()
                );
                if (reviewUI.getScore()==3){
                    reviewUI.setRatingColorID(1);
                }else if(reviewUI.getScore()==5){
                    reviewUI.setRatingColorID(2);
                }
                reviewsUI.add(reviewUI);
            }
        }
        reviewsView.showReviews(reviews);
    }

    @Override
    public void onError() {
        reviewsView.showGeneralError();

    }
}
