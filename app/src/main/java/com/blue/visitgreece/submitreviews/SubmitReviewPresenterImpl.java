package com.blue.visitgreece.submitreviews;


import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.blue.visitgreece.tourpackages.TourPackageUI;

public class SubmitReviewPresenterImpl implements
        SubmitReviewPresenter,
        SubmitReviewInteractor.OnSubmitReviewFinishListener  {

    private SubmitReviewInteractor interactor;
    private SubmitView view;

    public SubmitReviewPresenterImpl(SubmitView view) {
        this.view = view;
        interactor = new SubmitReviewInteractorImpl();
    }

    @Override
    public void onSuccess() {

        view.showSuccessMessage();

    }

    @Override
    public void onError() {

        view.showOnError();

    }

    @Override
    public void onNoRatingEntered() {
        view.showNoRatingError();
    }

    @Override
    public void stylize(TourPackageUI tourPackageUI, View view) {

        TextView mReviewPackageTitle = (TextView) view;

        mReviewPackageTitle.setText(tourPackageUI.getName());

    }

    @Override
    public void submitReview(TourPackageUI tourPackageUI, Context ctx, String reviewText, int reviewRating, String username) {

        interactor.submitReview(this, ctx, tourPackageUI, reviewText, reviewRating, username);

    }
}
