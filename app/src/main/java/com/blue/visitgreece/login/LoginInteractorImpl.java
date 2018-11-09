package com.blue.visitgreece.login;

import android.content.Context;

import com.blue.visitgreece.rest.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void verifyCredentials(final OnLoginFinishListener listener, final Context ctx, final String username, String password) {

        // Check if user exists on ArrayList
        final LoginDomain user = new LoginDomain(username, password);

        Call<LoginDomain> call = RestClient.call().login(user);
        call.enqueue(new Callback<LoginDomain>() {
            @Override
            public void onResponse(Call<LoginDomain> call, final Response<LoginDomain> response) {
                if (response.code() == 200) {
                    listener.onSuccess();
                    listener.setLastLoggedInUsername(ctx, username);
                } else {
                    listener.onWrongCredentialsError();
                }
            }

            @Override
            public void onFailure(Call<LoginDomain> call, Throwable t) {

            }
        });

    }

}
