package com.blue.visitgreece.tours;

import com.blue.visitgreece.tours.rest.RestClient;
import com.blue.visitgreece.tours.rest.responses.ToursResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToursInteractorImpl implements ToursInteractor{

    @Override
    public void getTours(final OnToursFinishListener listener, String tourpackagesId) {

        Call<ToursResponse> call = RestClient.call().fetchTours(tourpackagesId);

        call.enqueue(new Callback<ToursResponse>() {
            @Override
            public void onResponse(Call<ToursResponse> call, Response<ToursResponse> response) {
                ArrayList<TourDomain> tours = response.body().getResult().getItems();
                listener.onSuccess(tours);
            }
            @Override
            public void onFailure(Call<ToursResponse> call, Throwable t) {
            }
        });
    }
}
