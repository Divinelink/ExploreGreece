package com.blue.visitgreece.reviews;

import android.content.Context;

public interface ReviewsPresenter {

    void getReviews(Context ctx);

    void getFilteredReviews(int ratingFilter);

}
