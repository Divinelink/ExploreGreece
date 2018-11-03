package com.blue.visitgreece.rest;


import com.blue.visitgreece.login.LoginDomain;

import com.blue.visitgreece.rest.responses.TourpackageResponse;
import com.blue.visitgreece.reviews.ReviewDomain;
import com.blue.visitgreece.tourpackages.TourpackageDomain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestAPI {

    @GET("tourPackages")
    Call<ArrayList<TourpackageDomain>> fetchTourpacakges();

    @GET("tourPackages/{id}/reviews")
    Call<ArrayList<ReviewDomain>> fetchReviews(@Path("id") String tourPackageID);

    @POST("login")
    Call<LoginDomain> login(@Body LoginDomain loginDomain);

}
