package com.blue.visitgreece.tourpackages;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.blue.visitgreece.R;
import com.blue.visitgreece.base.HomeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class ToursPackagesFragment extends Fragment implements TourPackagesView {

    @BindView(R.id.tourspackage_Rv)
    RecyclerView toursPackage_rv;
    @BindView(R.id.filter_ed)
    EditText filter_ed;
    @BindView(R.id.tourpackages_root)
    SwipeRefreshLayout mTourPackages_root;

    TourPackagesPresenter presenter;
    HomeView homeView;

    public ToursPackagesFragment() {
        // Required empty public constructor
    }

    public static ToursPackagesFragment newInstance(HomeView homeView) {
        Bundle args = new Bundle();
        ToursPackagesFragment fragment = new ToursPackagesFragment();

        args.putSerializable("homeView", homeView);

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tourspackages, container, false);
        ButterKnife.bind(this, v);

        // Get arguments from bundle
        homeView = (HomeView) getArguments().getSerializable("homeView");

        mTourPackages_root.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getTourpackages(getActivity(), true);
            }
        });
        // Set up Layoutmanager in Recycler View
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        toursPackage_rv.setLayoutManager(layoutManager);
        presenter = new TourPackagesPresenterImpl(this);

        presenter.getTourpackages(getActivity(), true);

        filter_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //here is your code
                String filteredText = filter_ed.getText().toString();
                presenter.getFilteredTourPackages(filteredText, getContext());

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        return v;
    }

    @Override
    public void showTourPackages(final ArrayList<TourPackageUI> tourPackages) {
        mTourPackages_root.setRefreshing(false);
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                TourPackageRvAdapter tourPackagesRvAdapter = new TourPackageRvAdapter(tourPackages, new OnClickTourpackage() {
                    @Override
                    public void onTourPackageClicked(TourPackageUI tourPackage) {
                        // Pass id to another screen
                        homeView.addToursFragment(tourPackage);
                    }

                    @Override
                    public void onRateChangeClicked(TourPackageUI tourPackage) {
                        // GO to the review submit screen
                        Timber.d("Rate Clicked");
                    }
                }, getActivity());

                @Override
                public void run() {
                    toursPackage_rv.setAdapter(tourPackagesRvAdapter);
                }
            });
        }

    }

    @Override
    public void showGeneralError() {
        mTourPackages_root.setRefreshing(false);
    }


}
