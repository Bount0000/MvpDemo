package com.example.lenovo.mvpdemo.model;

import com.example.lenovo.mvpdemo.Api;
import com.example.lenovo.mvpdemo.Bean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/9/27.
 */

public class Loginmodel {
    private String msg;
    private String code;
    //登录
    public void login(String mobile,String psd)
    {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder=new FormBody.Builder();
        builder.add("mobile",mobile);
        builder.add("password",psd);
        FormBody body=builder.build();
        final Request request=new Request.Builder().post(body).url(Api.URL).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ilogin.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               if(response!=null&&response.isSuccessful())
               {
                   String s = response.body().string();
                   Jiexi(s);
                   if(code.equals("0"))
                   {
                       ilogin.LoginSucces(code,msg);
                   }
                   else
                   {
                       ilogin.LoginFail(code,msg);
                   }
               }
            }

            private void Jiexi(String s) {
                Gson gson=new  Gson();
                Bean user = gson.fromJson(s, Bean.class);
                code = user.getCode();
                 msg = user.getMsg();
            }
        });
    }
    //注册
    public void register(String mobile,String psd)
    {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder builder=new FormBody.Builder();
        builder.add("mobile",mobile);
        builder.add("password",psd);
        FormBody body=builder.build();
        final Request request=new Request.Builder().post(body).url(Api.Zhuce_URL).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ilogin.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response!=null&&response.isSuccessful())
                {
                    String s = response.body().string();
                    Jiexi(s);
                    if(code.equals("0"))
                    {
                        ilogin.LoginSucces(code,msg);
                    }
                    else
                    {
                        ilogin.LoginFail(code,msg);
                    }
                }
            }

            private void Jiexi(String s) {
                Gson gson=new  Gson();
                Bean user = gson.fromJson(s, Bean.class);
                code = user.getCode();
                msg = user.getMsg();
            }
        });
    }
     private ILogin ilogin;

     public void setIlogin(ILogin ilogin) {
        this.ilogin = ilogin;
    }

    public interface ILogin
    {
        void LoginSucces(String code,String msg);
        void LoginFail(String code,String msg);
        void onFailure(Call call, IOException e);
    }
}
