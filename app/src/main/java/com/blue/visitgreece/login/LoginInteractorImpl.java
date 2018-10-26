package com.blue.visitgreece.login;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoginInteractorImpl implements LoginInteractor {



    @Override
    public void getCredentials(OnLoginFinishListener listener) {

        // Make the call with the http client
        getMockedUserCreds();


    }


    private ArrayList<LoginDomain> getMockedUserCreds()
    {
        ArrayList<LoginDomain> mockedAccounts = new ArrayList<>();

        mockedAccounts.add(new LoginDomain("Haris", "123456789"));
        mockedAccounts.add(new LoginDomain("Thanasis" , "123456789"));
        mockedAccounts.add(new LoginDomain("Dimitris" , "123456789"));
        mockedAccounts.add(new LoginDomain("Xristina" , "123456789"));

        return mockedAccounts;

    }


}
