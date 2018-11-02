package com.blue.visitgreece.tourpackages;

import android.content.Context;

public interface TourpackagesPresenter {
    void getTourpackages(Context ctx);
    void getFilteredTourPackages(String filter);

}
