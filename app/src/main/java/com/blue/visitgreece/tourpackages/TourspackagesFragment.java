package com.blue.visitgreece.tourpackages;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blue.visitgreece.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TourspackagesFragment extends Fragment implements TourpackagesView{

    @BindView(R.id.tourspackage_Rv)
    RecyclerView tourspackage_rv;

    TourpackagesPresenter presenter;

    public TourspackagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tourspackages, container, false);
        ButterKnife.bind(this, v);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        tourspackage_rv.setLayoutManager(layoutManager);

        presenter = new TourpackagesPresenterImpl(this);
        presenter.getTourpackages();

        return v;
    }

    @Override
    public void showTourpackages(ArrayList<TourpackageUI> tourpackages) {
        TourpacakgeRvAdapter tourpackagesRvAdapter = new TourpacakgeRvAdapter(tourpackages, new OnClickTourpackage() {

            @Override
            public void onTourpackageClikced(TourpackageUI tourpackage) {
                // Pass id to another screen
            }

            @Override
            public void onRateChangeCllicked(TourpackageUI tourpackage) {
                // GO to the review submit screen
            }
        });
        tourspackage_rv.setAdapter(tourpackagesRvAdapter);
    }

    @Override
    public void showGeneralError() {

    }
}
