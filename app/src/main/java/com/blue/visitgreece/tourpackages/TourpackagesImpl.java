package com.blue.visitgreece.tourpackages;

import java.util.ArrayList;

public class TourpackagesImpl implements TourpackagesInteractor {

    @Override
    public void getTourpackages(OnTourpackagesFinishListener listener) {
        // HTTP calll perimenw
        listener.onSucces(mockDataTourpacakages());
        listener.onError();
    }

    private ArrayList<TourpackageDomain> mockDataTourpacakages() {
        ArrayList<TourpackageDomain> tourpackages = new ArrayList<>();
        tourpackages.add(new TourpackageDomain("1","Hikking",           "#FFFF0011","#0d9e23",4, Region.Aegean));
        tourpackages.add(new TourpackageDomain("2","Mountain climbing", "#0d9e23","#008577", 3,  Region.Ionian));
        tourpackages.add(new TourpackageDomain("3","Uknown",            "#008577","#FFFF0011",1, Region.Pelloponese));
        tourpackages.add(new TourpackageDomain("4","Trekking",          "#0d9e23","#00574B",5,   Region.Macedonia));
        return tourpackages;
    }
}
