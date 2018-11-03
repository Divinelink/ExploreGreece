package com.blue.visitgreece.rest;


import com.blue.visitgreece.rest.responses.TourpackageResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPI {

    @GET("tourPackages")
    Call<TourpackageResponse> fetchTourpacakges();



}
