package com.blue.visitgreece.login;

import android.widget.Toast;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishListener {

    private LoginInteractor interactor;
    private LoginView view;



    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void doLogin(String username, String password) {

        interactor.verifyCredentials(this, username, password);

    }

    @Override
    public void onSuccess() {
        view.showLoginDialog();
    }

    @Override
    public void onWrongCredentialsError() {
        view.showWrongCredentialsErrorDialog();
    }

    @Override
    public void onNoCredentialsEntered() {
        view.showBothAreRequired();
    }
}
