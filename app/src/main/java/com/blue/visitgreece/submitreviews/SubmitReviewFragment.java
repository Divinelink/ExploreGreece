package com.blue.visitgreece.submitreviews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blue.visitgreece.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmitReviewFragment extends Fragment {


    public SubmitReviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_submit_review, container, false);
    }

}
