package com.blue.visitgreece.tourpackages;

import android.content.Context;

import java.util.ArrayList;

public interface TourpackagesInteractor {
    void getTourpackages(OnTourpackagesFinishListener listener, Context ctx, boolean refresh);
    void getFilteredTourpackages(OnTourpackagesFinishListener listener, String filterString, Context ctx);

    interface OnTourpackagesFinishListener{
        void onSuccess(ArrayList<TourpackageDomain> tourpackages);
        void onError();
    }
}
