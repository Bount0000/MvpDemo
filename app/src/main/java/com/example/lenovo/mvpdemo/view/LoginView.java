package com.example.lenovo.mvpdemo.view;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by lenovo on 2017/9/27.
 */

public interface LoginView
{
    void Showprogressbar();
    void Hideprogressbar();

    void PhoneError(String msg);
    void psdError(String msg);

    void LoginSucces(String code,String msg);
    void LoginFail(String code,String msg);
    void onFailure(Call call, IOException e);

}
