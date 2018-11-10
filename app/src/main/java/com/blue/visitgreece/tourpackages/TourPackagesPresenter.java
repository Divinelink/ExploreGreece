package com.blue.visitgreece.tourpackages;

import android.content.Context;

public interface TourPackagesPresenter {
    void getTourpackages(Context ctx, boolean refresh);
    void getFilteredTourPackages(String filter, Context ctx);

}
