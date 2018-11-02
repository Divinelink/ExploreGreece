package com.blue.visitgreece.rest;


import com.blue.visitgreece.rest.responses.TourpackagesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPI {

    @GET("tourPackages")
    Call<TourpackagesResponse> fetchTourpacakges();



}
