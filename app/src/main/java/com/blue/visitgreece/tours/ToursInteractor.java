package com.blue.visitgreece.tours;

import java.util.ArrayList;

public interface ToursInteractor {
    void getTours(OnToursFinishListener listener, String tourpackagesId);

    interface OnToursFinishListener {
        void onSuccess(ArrayList<TourDomain> tours);
        void onError();
    }
}