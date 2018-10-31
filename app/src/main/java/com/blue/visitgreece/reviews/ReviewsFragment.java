package com.blue.visitgreece.reviews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.blue.visitgreece.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewsFragment extends Fragment implements ReviewsView {

    @BindView(R.id.reviews_rv)
    RecyclerView reviewsRv;

    @BindView(R.id.filter_edit_text)
    EditText mFilterEditText;

    ReviewsPresenter presenter;


    public ReviewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reviews, container, false);
        ButterKnife.bind(this, v);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        reviewsRv.setLayoutManager(layoutManager);
        presenter = new ReviewsPresenterImp(this);
        presenter.getReviews();

        return v;

    }


    @Override
    public void showReviews(ArrayList<ReviewDomain> reviews) {
        ReviewsRvAdapter adapter = new ReviewsRvAdapter(reviews);
        reviewsRv.setAdapter(adapter);
    }

    @Override
    public void showGeneralError() {
        Toast.makeText(getContext(), getString(R.string.error_message), Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.filter_button)
    public void filterReviews(View view) {
        String filterText = mFilterEditText.getText().toString();
        presenter.getFilteredReviews(Integer.parseInt(filterText)); //parse int to string or string?
    }
}
