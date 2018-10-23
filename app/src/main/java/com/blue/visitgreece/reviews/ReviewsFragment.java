package com.blue.visitgreece.reviews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blue.visitgreece.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewsFragment extends Fragment implements ReviewsView {

    RecyclerView reviewsRv;
    ReviewsPresenter presenter;


    public ReviewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reviews, container, false);


        reviewsRv = v.findViewById(R.id.reviews_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        reviewsRv.setLayoutManager(layoutManager);
        presenter = new ReviewsPresenterImp(this);
        presenter.getReviews();

        return v;

    }


    @Override
    public void showReviews(ArrayList<Review> reviews) {
        ReviewsRvAdapter adapter = new ReviewsRvAdapter(reviews);
        reviewsRv.setAdapter(adapter);
    }
}
