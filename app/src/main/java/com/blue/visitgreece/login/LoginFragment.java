package com.blue.visitgreece.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blue.visitgreece.R;

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
        presenter.doLogin(username, password);


    }

    LoginPresenter presenter;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, v);



        presenter = new LoginPresenterImpl(this);


        return v;
    }

    @Override
    public void showLoginDialog() {

    }
}
