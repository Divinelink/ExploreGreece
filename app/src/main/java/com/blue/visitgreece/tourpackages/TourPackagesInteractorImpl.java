package com.blue.visitgreece.tourpackages;

import android.content.Context;
import android.os.AsyncTask;


import com.blue.visitgreece.base.VisitGreeceDatabase;
import com.blue.visitgreece.rest.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TourPackagesInteractorImpl implements TourPackagesInteractor {

    /**
     * Get Tourpackages from network
     * @param listener
     * @param ctx
     */
    @Override
    public void getTourpackages(final OnTourpackagesFinishListener listener, final Context ctx, final boolean refresh) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                final TourPackagesDao tourPackagesDao = VisitGreeceDatabase.getDatabase(ctx).tourpackagesDao();
                List<TourPackageDomain> tourpackagesFromDb   = tourPackagesDao.getAllTourpackages();
                ArrayList<TourPackageDomain> arrayListFromDb = new ArrayList<>();
                arrayListFromDb.addAll(tourpackagesFromDb);

                if(tourpackagesFromDb.isEmpty() || refresh){
                    Call<ArrayList<TourPackageDomain>> call = RestClient.call().fetchTourpacakges();
                    call.enqueue(new Callback<ArrayList<TourPackageDomain>>() {
                        @Override
                        public void onResponse(Call<ArrayList<TourPackageDomain>> call, final Response<ArrayList<TourPackageDomain>> response) {
                            AsyncTask.execute(new Runnable() {
                                @Override
                                public void run() {
                                    tourPackagesDao.updateTourpackages(response.body());
                                    listener.onSuccess(response.body());
                                }
                            });
                        }

                        @Override
                        public void onFailure(Call<ArrayList<TourPackageDomain>> call, Throwable t) {
                            listener.onError();
                        }

                    });
                }else{
                    listener.onSuccess(arrayListFromDb);
                }
            }
        });
    }

    /**
     * Filter tourpackages: Get from filter the specific tourpackages by Region
     * @param listener
     * @param filterString
     */
    @Override
    public void getFilteredTourpackages(final OnTourpackagesFinishListener listener, final String filterString, final Context ctx) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                final TourPackagesDao tourPackagesDao = VisitGreeceDatabase.getDatabase(ctx).tourpackagesDao();
                List<TourPackageDomain> tourpackagesFromDb   = tourPackagesDao.getFilteredTourpackages(filterString);
                ArrayList<TourPackageDomain> arrayListFromDb = new ArrayList<>();
                arrayListFromDb.addAll(tourpackagesFromDb);
                listener.onSuccess(arrayListFromDb);
            }
        });
    }
}
