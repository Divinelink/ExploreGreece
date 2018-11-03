package com.blue.visitgreece.login;

import com.blue.visitgreece.rest.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void verifyCredentials(final OnLoginFinishListener listener, String username, String password) {

        // Check if user exists on ArrayList
        final LoginDomain user = new LoginDomain(username, password);

        Call<LoginDomain> call = RestClient.call().login(user);
        call.enqueue(new Callback<LoginDomain>() {
            @Override
            public void onResponse(Call<LoginDomain> call, final Response<LoginDomain> response) {
                if (response.code() == 200){
                    listener.onSuccess();
                }
                else{
                    listener.onWrongCredentialsError();
                }
            }

            @Override
            public void onFailure(Call<LoginDomain> call, Throwable t) {

            }
        });

    }

    private ArrayList<LoginDomain> getMockedUsers()
    {
        ArrayList<LoginDomain> mockedAccounts = new ArrayList<>();
        mockedAccounts.add(new LoginDomain("Haris", "123456789"));
        mockedAccounts.add(new LoginDomain("Thanasis" , "123456789"));
        mockedAccounts.add(new LoginDomain("Dimitris" , "123456789"));
        mockedAccounts.add(new LoginDomain("Xristina" , "123456789"));

        return mockedAccounts;
    }


}
