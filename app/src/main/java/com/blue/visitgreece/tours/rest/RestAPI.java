package com.blue.visitgreece.tours.rest;

import com.blue.visitgreece.tours.rest.responses.ToursResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestAPI {

    @GET("tourpackages")
    Call<ToursResponse>fetchTours(@Query("tourpackagesId") String tourpackagesId);

}