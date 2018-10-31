package com.blue.visitgreece.login;

public interface LoginInteractor {

    void verifyCredentials (OnLoginFinishListener listener, String username, String password);

    interface OnLoginFinishListener {

        void onSuccess();

        void onWrongCredentialsError();

        void onNoCredentialsEntered();
    }
}
