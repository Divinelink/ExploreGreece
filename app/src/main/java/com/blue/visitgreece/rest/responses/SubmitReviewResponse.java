package com.blue.visitgreece.rest.responses;

import com.blue.visitgreece.reviews.ReviewDomain;

public class SubmitReviewResponse {

    private ReviewDomain Result;

    public SubmitReviewResponse(ReviewDomain result) {
        Result = result;
    }

    public ReviewDomain getResult() {
        return Result;
    }

    public void setResult(ReviewDomain result) {
        Result = result;
    }
}
