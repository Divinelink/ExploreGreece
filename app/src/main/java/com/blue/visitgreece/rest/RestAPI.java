package com.blue.visitgreece.rest;


import com.blue.visitgreece.rest.responses.ToursResponse;
import com.blue.visitgreece.reviews.ReviewDomain;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestAPI {

    @GET("tourPackages/{id}/reviews")
    Call<ArrayList<ReviewDomain>> fetchReviews(@Path("id") String tourPackageID);

    @GET("tourPackages/{id}/tours")
    Call<ToursResponse> fetchTours(@Path("id") String tourpackageId);


}
