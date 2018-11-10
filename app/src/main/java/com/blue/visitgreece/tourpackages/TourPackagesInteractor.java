package com.blue.visitgreece.tourpackages;

import android.content.Context;

import java.util.ArrayList;

public interface TourPackagesInteractor {
    void getTourpackages(OnTourpackagesFinishListener listener, Context ctx, boolean refresh);
    void getFilteredTourpackages(OnTourpackagesFinishListener listener, String filterString, Context ctx);

    interface OnTourpackagesFinishListener{
        void onSuccess(ArrayList<TourPackageDomain> tourpackages);
        void onError();
    }
}
