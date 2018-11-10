package com.blue.visitgreece.login;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blue.visitgreece.R;
import com.blue.visitgreece.base.HomeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginFragment extends Fragment implements LoginView {

    @BindView(R.id.email_login_edit_text)
    EditText mEmailEditText;
    @BindView(R.id.password_login_edit_text)
    EditText mPasswordEditText;

    @OnClick(R.id.button_login)
    public void submit(){

        final String username = mEmailEditText.getText().toString();
        final String password = mPasswordEditText.getText().toString();
        presenter.doLogin(getActivity() , username, password);
    }

    LoginPresenter presenter;
    HomeView homeView;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(HomeView homeView) {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        args.putSerializable("home_view", homeView);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, v);

        homeView = (HomeView) getArguments().getSerializable("home_view");

        presenter = new LoginPresenterImpl(this);

        return v;
    }

    @Override
    public void showLoginDialog() {

        homeView.addToursPackageFragment();

    }

    @Override
    public void showWrongCredentialsErrorDialog() {
        Toast.makeText(getActivity(), "Incorrect email or password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBothAreRequired() {
        Toast.makeText(getActivity(), "Enter email and password", Toast.LENGTH_SHORT).show();
    }


}
