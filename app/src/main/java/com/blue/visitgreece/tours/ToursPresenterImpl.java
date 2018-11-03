package com.blue.visitgreece.tours;

import com.blue.visitgreece.R;

import java.util.ArrayList;

public class ToursPresenterImpl implements ToursPresenter, ToursInteractor.OnToursFinishListener {

    ToursView view;
    ToursInteractor interactor;

    public ToursPresenterImpl(ToursView view) {
        this.view = view;
        interactor = new ToursInteractorImpl();
    }


    @Override
    public void getTours(String tourpackageId) {
        interactor.getTours(this, tourpackageId);
    }


    @Override
    public void onSuccess(ArrayList<TourDomain> tours) {
        ArrayList<TourUI> toursUI = new ArrayList<>();
        for (TourDomain tourd : tours) {
            TourUI tourUi = new TourUI(tourd.getId(),tourd.getTitle(), tourd.getDescription(), R.color.colorPrimaryDark);
            toursUI.add(tourUi);
        }
        view.showTours(toursUI);
    }
    @Override
    public void onError() {

    }
}
