package com.blue.visitgreece.login;

public interface LoginInteractor {

    void getCredentials (OnLoginFinishListener listener);

    interface OnLoginFinishListener {

        void onSuccess();

        void onError();
    }
}
