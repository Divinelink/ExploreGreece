package com.blue.visitgreece.tours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

import com.blue.visitgreece.R;
import com.blue.visitgreece.tourpackages.TourpackageUI;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToursFragment extends Fragment implements ToursView {

    RecyclerView mToursRv;
    ToursPresenter presenter;

    @BindView(R.id.tourpackage_name) //bind με προηγούμενη οθόνη
            TextView mTourpackageName;
            TextView mTourpackageRegion;
            TextView mTourpackageRating;

    @BindView(R.id.button_rev)
            Button mButtonRev;

    @BindView(R.id.button_all_rev)
            Button mButtonAllRev;


    public ToursFragment() {

    }

    public static ToursFragment newInstance(TourpackageUI tourpackage) { //UI προηγούμενης οθόνης
        ToursFragment myFragment = new ToursFragment();
        Bundle args = new Bundle();
        args.putParcelable("tourpackage", tourpackage);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TourpackageUI tourpackage = getArguments().getParcelable("tourpackage");
        Timber.e(tourpackage.getId()); //logging

        View v = inflater.inflate(R.layout.fragment_tours, container, false);
        ButterKnife.bind(this, v);
        Timber.e(tourpackage.getRegion().toString());
        //mTourpackageName.setText(tourpackage.getName()); //από TourpackageUI
        //mTourpackageRegion.setText(tourpackage.getRegion());
        //mTourpackageRating.setText(tourpackage.getRating());

        mToursRv = v.findViewById(R.id.tours_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mToursRv.setLayoutManager(layoutManager);

        presenter = new ToursPresenterImpl(this);
        presenter.getTours(tourpackage.getId());  // να προστεθεί στην προηγούμενη οθόνη
        return v;

        /*
        mButtonRev = v.findViewById(R.id.button_rev);
        mButtonRev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Etkos on createview dilonete to onclick logo butter knife

            }
        });
        */
        /*
        mButtonAllRev = v.findViewById(R.id.button_all_rev);
        mButtonAllRev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();  //να προστεθεί Intent all reviews //Butterknife?
                startActivity(intent);
                getActivity();
            }
        });
        */
    }

    @OnClick(R.id.button_rev)
    public void OnclickReview(View v){
        Intent intent = new Intent(); //να προστεθεί Intent reviews //Butterknife?
        startActivity(intent);
        getActivity();

    }

    @Override
    public void showTours(ArrayList<TourUI> tours) {
        ToursRvAdapter toursRvAdapter = new ToursRvAdapter(tours, getActivity());
        mToursRv.setAdapter(toursRvAdapter);
    }
}



