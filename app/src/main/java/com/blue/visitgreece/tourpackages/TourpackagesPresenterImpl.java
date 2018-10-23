package com.blue.visitgreece.tourpackages;

import java.util.ArrayList;

public class TourpackagesPresenterImpl implements TourpackagesPresenter,
        TourpackagesInteractor.OnTourpackagesFinishListener {
    TourpackagesView tourpackagesView;
    TourpackagesInteractor interactor;


    public TourpackagesPresenterImpl(TourpackagesView tourpackagesView) {
        this.tourpackagesView = tourpackagesView;
        this.interactor = new TourpackagesImpl();
    }

    @Override
    public void getTourpackages() {
        interactor.getTourpackages(this);
    }

    @Override
    public void getFilteredTourPackages(String filter) {
        // Ερωτηση : Γιατι περναέι και τον Listener Μέσα;;;
        interactor.getFilteredTourpackages(this,filter);
    }

    @Override
    public void onSucces(ArrayList<TourpackageDomain> tourpackages) {
        ArrayList<TourpackageUI> tourpackagesUI = new ArrayList<>();
        if (tourpackages != null && !tourpackages.isEmpty()) {

            for (TourpackageDomain tourpackage : tourpackages) {

                TourpackageUI tourpackageUI = new TourpackageUI(tourpackage.getName(),
                        tourpackage.getRatingColor(),
                        tourpackage.getRegionColor(),
                        tourpackage.getRating(),
                        tourpackage.getRegion());

                // Logiki view
                Region region = tourpackageUI.getRegion();

                switch(region){
                    case Crete:        tourpackageUI.setRegionColor(tourpackage.getRegionColor());
                        break;
                    case Aegean:       tourpackageUI.setRegionColor(tourpackage.getRegionColor());
                        break;
                    case Ionian:       tourpackageUI.setRegionColor(tourpackage.getRegionColor());
                        break;
                    case Thrace:       tourpackageUI.setRegionColor(tourpackage.getRegionColor());
                        break;
                    case Thessaly:     tourpackageUI.setRegionColor(tourpackage.getRegionColor());
                        break;
                    case StereaHellas: tourpackageUI.setRegionColor(tourpackage.getRegionColor());
                        break;
                    case Pelloponese:  tourpackageUI.setRegionColor(tourpackage.getRegionColor());
                        break;
                    case Macedonia:    tourpackageUI.setRegionColor(tourpackage.getRegionColor());
                        break;
                    default:
                                       tourpackageUI.setRatingColor(tourpackage.getRegionColor());
                        break;
                }
                tourpackagesUI.add(tourpackageUI);
            }
        }
        tourpackagesView.showTourpackages(tourpackagesUI);
    }

    @Override
    public void onError() {
        tourpackagesView.showGeneralError();
    }

}
