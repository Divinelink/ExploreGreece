package com.blue.visitgreece.rest;


import com.blue.visitgreece.rest.responses.ReviewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestAPI {

    @GET("tourPackages/{id}/reviews")
    Call<ReviewsResponse> fetchReviews(@Path("id") String tourPackageID);

}
