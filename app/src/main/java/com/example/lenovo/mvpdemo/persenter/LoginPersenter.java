package com.example.lenovo.mvpdemo.persenter;

import android.text.TextUtils;

import com.example.lenovo.mvpdemo.model.Loginmodel;
import com.example.lenovo.mvpdemo.view.LoginView;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by lenovo on 2017/9/27.
 */

public class LoginPersenter implements Loginmodel.ILogin {
    private Loginmodel loginmodel;
    private LoginView loginView;

    public LoginPersenter(LoginView loginView) {
        loginmodel=new Loginmodel();
        this.loginView = loginView;
        loginmodel.setIlogin(this);
    }

    public void login(String mobile,String psd)
    {
        if(TextUtils.isEmpty("phone"))
        {
            loginView.PhoneError("手机号为空");
            return;
        }
        if(TextUtils.isEmpty("psd"))
        {
            loginView.PhoneError("密码号为空");
            return;
        }
        loginmodel.login(mobile,psd);
    }
    public void register(String mobile,String psd)
    {
        if(TextUtils.isEmpty("phone"))
        {
            loginView.PhoneError("手机号为空");
            return;
        }
        if(TextUtils.isEmpty("psd"))
        {
            loginView.PhoneError("密码号为空");
            return;
        }
        loginmodel.register(mobile,psd);
    }
    @Override
    public void LoginSucces(String code, String msg) {
        loginView.Hideprogressbar();
        loginView.LoginSucces(code,msg);
    }

    @Override
    public void LoginFail(String code, String msg) {
        loginView.Hideprogressbar();
        loginView.LoginFail(code,msg);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        loginView.Hideprogressbar();
        loginView.onFailure(call,e);
    }
}
