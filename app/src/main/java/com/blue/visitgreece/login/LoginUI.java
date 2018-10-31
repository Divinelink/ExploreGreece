package com.blue.visitgreece.login;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginUI implements Parcelable {

    private String username;
    private String password;

    public LoginUI() { }

    public LoginUI(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    protected LoginUI(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<LoginUI> CREATOR = new Parcelable.Creator<LoginUI>() {
        @Override
        public LoginUI createFromParcel(Parcel in) {
            return new LoginUI(in);
        }

        @Override
        public LoginUI[] newArray(int size) {
            return new LoginUI[size];
        }
    };
}
