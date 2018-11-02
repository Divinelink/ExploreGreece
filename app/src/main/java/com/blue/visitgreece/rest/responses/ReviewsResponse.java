package com.blue.visitgreece.rest.responses;

import com.blue.visitgreece.reviews.ReviewDomain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReviewsResponse {


    private ArrayList<ReviewDomain> Result;

    public ReviewsResponse(ArrayList<ReviewDomain> result) {
        Result = result;
    }

    public ArrayList<ReviewDomain> getResult() {
        return Result;
    }

    public void setResult(ArrayList<ReviewDomain> result){
    Result = result;
    }
}
