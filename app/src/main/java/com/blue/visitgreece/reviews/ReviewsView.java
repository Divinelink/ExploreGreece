package com.blue.visitgreece.reviews;

import java.util.ArrayList;

public interface ReviewsView {

    void showReviews(ArrayList<ReviewDomain> reviews);

    void showGeneralError();

}
