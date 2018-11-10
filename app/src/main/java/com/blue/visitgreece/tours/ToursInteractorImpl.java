package com.blue.visitgreece.tours;

import android.content.Context;
import android.os.AsyncTask;
import com.blue.visitgreece.base.VisitGreeceDatabase;
import com.blue.visitgreece.rest.RestClient;
import com.blue.visitgreece.tourpackages.TourPackageUI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ToursInteractorImpl implements ToursInteractor {


    @Override
    public void getTours(final OnToursFinishListener listener, final Context ctx, final TourPackageUI tourpackageUI, final Boolean refresh) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                final String tourPackageId = tourpackageUI.getId();
                final ToursDao toursDao = VisitGreeceDatabase.getDatabase(ctx).toursDao();
                List<TourDomain> toursFromDb = toursDao.getTourByID(tourPackageId);
                ArrayList<TourDomain> arrayListFromDb = new ArrayList<>();
                arrayListFromDb.addAll(toursFromDb);

                if (toursFromDb.isEmpty() || refresh) {
                    Call<ArrayList<TourDomain>> call = RestClient.call().fetchTours(tourPackageId);
                    call.enqueue(new Callback<ArrayList<TourDomain>>() {
                        @Override
                        public void onResponse(Call<ArrayList<TourDomain>> call, final Response<ArrayList<TourDomain>> response) {
                            AsyncTask.execute(new Runnable() {
                                @Override
                                public void run() {
                                    final ArrayList<TourDomain> tours = response.body();

                                    AsyncTask.execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            toursDao.updateToursForTourpackage(tours, tourPackageId);
                                        }
                                    });
                                    listener.onSuccess(tours);
                                }
                            });
                        }

                        @Override
                        public void onFailure(Call<ArrayList<TourDomain>> call, Throwable t) {

                        }
                    });
                }else{
                    listener.onSuccess(arrayListFromDb);
                }
            }
        });
    }
}