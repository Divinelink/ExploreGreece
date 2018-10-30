package com.blue.visitgreece.tourpackages;

import java.util.ArrayList;

public class TourpackagesInteractorImpl implements TourpackagesInteractor {

    /**
     * Show Dummy TourPackages
     * @param listener
     */
    @Override
    public void getTourpackages(OnTourpackagesFinishListener listener) {
        // HTTP calll perimenw
        listener.onSucces(mockDataTourpacakages());
        listener.onError();
    }

    /**
     * Filter tourpackages: Get from filter the specific tourpackages by Region
     * @param listener
     * @param filter
     */
    @Override
    public void getFilteredTourpackages(OnTourpackagesFinishListener listener, String filter) {
        ArrayList<TourpackageDomain> tourpackages         = mockDataTourpacakages();
        ArrayList<TourpackageDomain> filteredtourpackages = new ArrayList<>();

        // Search tourpackages
        for(int i = 0; i < tourpackages.size(); i++){
            if(tourpackages.get(i).getRegion().toString().startsWith(filter)){
                filteredtourpackages.add(tourpackages.get(i));
            }
        }
        listener.onSucces(filteredtourpackages);
    }

    private ArrayList<TourpackageDomain> mockDataTourpacakages() {
        ArrayList<TourpackageDomain> tourpackages = new ArrayList<>();
        tourpackages.add(new TourpackageDomain("1","Hikking",           "#FFFF0011","#0d9e23",4, "Aegean"));
        tourpackages.add(new TourpackageDomain("2","Mountain climbing", "#0d9e23","#008577", 3,  "Ionian"));
        tourpackages.add(new TourpackageDomain("3","Uknown",            "#008577","#FFFF0011",1, "Pelloponese"));
        tourpackages.add(new TourpackageDomain("4","Trekking",          "#0d9e23","#00574B",5,   "Macedonia"));
        return tourpackages;
    }
}
