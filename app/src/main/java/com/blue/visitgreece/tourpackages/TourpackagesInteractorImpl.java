package com.blue.visitgreece.tourpackages;

import android.os.AsyncTask;


import com.blue.visitgreece.rest.RestClient;
import com.blue.visitgreece.rest.responses.TourpackageResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class TourpackagesInteractorImpl implements TourpackagesInteractor {

    /**
     * Show Dummy TourPackages
     * @param listener
     */
    @Override
    public void getTourpackages(final OnTourpackagesFinishListener listener) {


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Call<TourpackageResponse> call = RestClient.call().fetchTourpacakges();

                call.enqueue(new Callback<TourpackageResponse>() {
                    @Override
                    public void onResponse(Call<TourpackageResponse> call, final Response<TourpackageResponse> response) {
                        AsyncTask.execute(new Runnable() {
                            @Override
                            public void run() {

                                
                                //listener.onSucces(response.body().get_embedded());

                            }
                        });

                    }

                    @Override
                    public void onFailure(Call<TourpackageResponse> call, Throwable t) {
                        Timber.e(t.toString());
                        listener.onError();

                    }
                });
            }
        });
    }

    /**
     * Filter tourpackages: Get from filter the specific tourpackages by Region
     * @param listener
     * @param filter
     */
    @Override
    public void getFilteredTourpackages(OnTourpackagesFinishListener listener, String filter) {
        /*
        ArrayList<TourpackageDomain> tourpackages         = mockDataTourpacakages();
        ArrayList<TourpackageDomain> filteredtourpackages = new ArrayList<>();

        // Search tourpackages
        for(int i = 0; i < tourpackages.size(); i++){
            if(tourpackages.get(i).getRegion().toString().startsWith(filter)){
                filteredtourpackages.add(tourpackages.get(i));
            }
        }
        listener.onSucces(filteredtourpackages);
        */
    }

    /*
    private ArrayList<TourpackageDomain> mockDataTourpacakages() {
        ArrayList<TourpackageDomain> tourpackages = new ArrayList<>();
        tourpackages.add(new TourpackageDomain("1","Hikking",           "#FFFF0011","#0d9e23",4, "Aeagean"));
        tourpackages.add(new TourpackageDomain("2","Mountain climbing", "#0d9e23","#008577", 3,  "Ionian"));
        tourpackages.add(new TourpackageDomain("3","Uknown",            "#008577","#FFFF0011",1, "Peloponnese"));
        tourpackages.add(new TourpackageDomain("4","Trekking",          "#0d9e23","#00574B",5,   "Macedonia"));
        return tourpackages;
    }
    */
    private ArrayList<TourpackageDomain> mockDataTourpacakages2() {
        ArrayList<TourpackageDomain> tourpackages = new ArrayList<>();
        tourpackages.add(new TourpackageDomain("1","Hikking","Aeagean"));
        tourpackages.add(new TourpackageDomain("2","Mountain climbing",  "Ionian"));
        tourpackages.add(new TourpackageDomain("3","Uknown",           "Peloponnese"));
        tourpackages.add(new TourpackageDomain("4","Trekking",         "Macedonia"));
        return tourpackages;
    }

}
