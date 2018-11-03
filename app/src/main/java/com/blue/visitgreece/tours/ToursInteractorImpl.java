package com.blue.visitgreece.tours;

import com.blue.visitgreece.rest.responses.ToursResponse;
import com.blue.visitgreece.rest.RestClient;
import com.blue.visitgreece.rest.responses.ToursResponse;

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
                ArrayList<TourDomain> tours = response.body().getResult().getTours().getData();
                listener.onSuccess(tours);
            }
            @Override
            public void onFailure(Call<ToursResponse> call, Throwable t) {
            }
        });
    }
}
