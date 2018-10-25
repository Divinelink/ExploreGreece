package com.blue.visitgreece.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.blue.visitgreece.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginFragment extends Fragment {

    @BindView(R.id.email_login_edit_text)
    EditText mEmailEditText;
    @BindView(R.id.password_login_edit_text)
    EditText mPasswordEditText;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, v);



        return v;
    }

}
