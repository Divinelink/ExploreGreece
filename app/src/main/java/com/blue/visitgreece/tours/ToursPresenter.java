package com.blue.visitgreece.tours;

import android.content.Context;

import com.blue.visitgreece.tourpackages.TourPackageUI;

public interface ToursPresenter {
    void getTours(Context ctx, TourPackageUI tourpackageUI, Boolean refresh);
}
