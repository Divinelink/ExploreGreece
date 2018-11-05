package com.blue.visitgreece.tourpackages;

import android.content.Context;
import android.os.AsyncTask;


import com.blue.visitgreece.base.VisitGreeceDatabase;
import com.blue.visitgreece.rest.RestClient;
import com.blue.visitgreece.rest.responses.TourpackageResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class TourpackagesInteractorImpl implements TourpackagesInteractor {

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
                final TourpackagesDao  tourpackagesDao       = VisitGreeceDatabase.getDatabase(ctx).tourpackagesDao();
                List<TourpackageDomain> tourpackagesFromDb   = tourpackagesDao.getAllTourpackages();
                ArrayList<TourpackageDomain> arrayListFromDb = new ArrayList<>();
                arrayListFromDb.addAll(tourpackagesFromDb);

                if(tourpackagesFromDb.isEmpty() || refresh){
                    Call<ArrayList<TourpackageDomain>> call = RestClient.call().fetchTourpacakges();
                    call.enqueue(new Callback<ArrayList<TourpackageDomain>>() {
                        @Override
                        public void onResponse(Call<ArrayList<TourpackageDomain>> call, final Response<ArrayList<TourpackageDomain>> response) {
                            AsyncTask.execute(new Runnable() {
                                @Override
                                public void run() {
                                    tourpackagesDao.updateTourpackages(response.body());
                                    listener.onSuccess(response.body());
                                }
                            });
                        }

                        @Override
                        public void onFailure(Call<ArrayList<TourpackageDomain>> call, Throwable t) {
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
                final TourpackagesDao  tourpackagesDao       = VisitGreeceDatabase.getDatabase(ctx).tourpackagesDao();
                List<TourpackageDomain> tourpackagesFromDb   = tourpackagesDao.getFilteredTourpackages(filterString);
                ArrayList<TourpackageDomain> arrayListFromDb = new ArrayList<>();
                arrayListFromDb.addAll(tourpackagesFromDb);
                listener.onSuccess(arrayListFromDb);
            }
        });
    }
}
