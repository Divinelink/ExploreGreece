package com.blue.visitgreece.login;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishListener {

    private LoginInteractor interactor;
    private LoginView view;



    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void getCredentials() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }
}
