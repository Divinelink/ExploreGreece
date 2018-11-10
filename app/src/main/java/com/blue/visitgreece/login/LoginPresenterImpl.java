package com.blue.visitgreece.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.blue.visitgreece.R;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishListener {

    private LoginInteractor interactor;
    private LoginView view;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void doLogin(Context ctx, String username, String password) {

        interactor.verifyCredentials(this, ctx, username, password);

    }

    @Override
    public void onSuccess() {
        view.showLoginDialog();
    }

    //TODO Is this correct? Should it be here?
    @Override
    public void setLastLoggedInUsername(Context ctx, String username) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", username);
        editor.commit();

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
