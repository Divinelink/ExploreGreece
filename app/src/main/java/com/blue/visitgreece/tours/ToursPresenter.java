package com.blue.visitgreece.tours;

import android.content.Context;

import com.blue.visitgreece.tourpackages.TourpackageUI;

public interface ToursPresenter {
    void getTours(Context ctx, TourpackageUI tourpackageUI, Boolean refresh);
}
