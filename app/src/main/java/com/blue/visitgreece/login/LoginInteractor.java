package com.blue.visitgreece.login;

import android.content.Context;

public interface LoginInteractor {

    void verifyCredentials (OnLoginFinishListener listener, Context ctx, String username, String password);

    interface OnLoginFinishListener {

        void onSuccess();

        void setLastLoggedInUsername(Context ctx, String username);

        void onWrongCredentialsError();

        void onNoCredentialsEntered();
    }
}
