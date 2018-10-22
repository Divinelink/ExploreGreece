package com.blue.visitgreece.tourpackages;

import java.util.ArrayList;

public interface TourpackagesInteractor {
    void getTourpackages(OnTourpackagesFinishListener listener);

    interface OnTourpackagesFinishListener{
        void onSucces(ArrayList<TourpackageDomain> tourpackages);
        void onError();
    }
}
