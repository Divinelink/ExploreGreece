package com.blue.visitgreece.rest;


import com.blue.visitgreece.login.LoginDomain;
import com.blue.visitgreece.reviews.ReviewDomain;
import com.blue.visitgreece.tourpackages.TourPackageDomain;
import com.blue.visitgreece.tours.TourDomain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestAPI {

    @GET("tourPackages")
    Call<ArrayList<TourPackageDomain>> fetchTourpacakges();

    @GET("tourPackages/{id}/reviews")
    Call<ArrayList<ReviewDomain>> fetchReviews(@Path("id") String tourPackageID);

    @GET("tourPackages/{id}/tours")
    Call<ArrayList<TourDomain>> fetchTours(@Path("id") String tourpackageId);

    @POST("login")
    Call<LoginDomain> login(@Body LoginDomain loginDomain);

    @POST("tourPackages/{id}/reviews")
    Call<Void> postReview(@Body ReviewDomain reviewDomain, @Path("id") String tourPackageId);

}
