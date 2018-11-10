package com.blue.visitgreece.tours;

import android.content.Context;

import com.blue.visitgreece.tourpackages.TourpackageUI;

import java.util.ArrayList;

public interface ToursInteractor {
    void getTours(OnToursFinishListener listener, Context ctx, TourpackageUI tourpackageUI, Boolean refresh);

    interface OnToursFinishListener {
        void onSuccess(ArrayList<TourDomain> tours);
        void onError();
    }
}