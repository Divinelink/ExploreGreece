package com.blue.visitgreece.tours;

import com.blue.visitgreece.rest.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToursInteractorImpl implements ToursInteractor{

    @Override
    public void getTours(final OnToursFinishListener listener, String tourpackagesId) {

        Call<ArrayList<TourDomain>> call = RestClient.call().fetchTours(tourpackagesId);

        call.enqueue(new Callback<ArrayList<TourDomain>>() {
            @Override
            public void onResponse(Call<ArrayList<TourDomain>> call, Response<ArrayList<TourDomain>> response) {
                ArrayList<TourDomain> tours = response.body();
                listener.onSuccess(tours);
            }
            @Override
            public void onFailure(Call<ArrayList<TourDomain>> call, Throwable t) {
            }
        });
    }
}
