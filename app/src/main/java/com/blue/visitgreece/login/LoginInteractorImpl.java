package com.blue.visitgreece.login;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void verifyCredentials(OnLoginFinishListener listener, String username, String password) {

        // Check if user exists on ArrayList
        LoginDomain user = new LoginDomain(username, password);

        for (int i = 0; i < getMockedUsers().size(); i++)
        {
            if (getMockedUsers().get(i).getUsername().matches(user.getUsername())
                    && getMockedUsers().get(i).getPassword().matches(user.getPassword()))
            {
                listener.onSuccess();
                break;
            }
            else if (user.getPassword().equals("") || user.getUsername().equals(""))
                listener.onNoCredentialsEntered();
            else
                listener.onWrongCredentialsError();

        }
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
