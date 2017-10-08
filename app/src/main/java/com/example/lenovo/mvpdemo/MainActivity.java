package com.example.lenovo.mvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lenovo.mvpdemo.persenter.LoginPersenter;
import com.example.lenovo.mvpdemo.view.LoginView;

import java.io.IOException;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {
    private EditText et_phone;
    private EditText et_psd;
    private Button login;
    private Button register;
    private ProgressBar progerss;
    private LoginPersenter presenter;

    //private LoginPersenter persenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initDate() {

        presenter = new LoginPersenter(this);
    }

    private void initView() {
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_psd = (EditText) findViewById(R.id.et_psd);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
        progerss = (ProgressBar) findViewById(R.id.progerss);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.login:
                presenter.login(et_phone.getText().toString(),et_psd.getText().toString());
               break;
              case R.id.register:
                presenter.register(et_phone.getText().toString(),et_psd.getText().toString());
                break;
        }
   }
    @Override
    public void Showprogressbar() {
     runOnUiThread(new Runnable() {
         @Override
         public void run() {
             progerss.setVisibility(View.VISIBLE);
         }
     });
    }

    @Override
    public void Hideprogressbar() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progerss.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void PhoneError(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void psdError(final String msg) {
      runOnUiThread(new Runnable() {
          @Override
          public void run() {
              Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
          }
      });
    }

    @Override
    public void LoginSucces(String code, String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"登录成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                String phone = et_phone.getText().toString();
                intent.putExtra("phone",phone);
                startActivity(intent);
            }
        });
    }

    @Override
    public void LoginFail(String code, String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"登录失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onFailure(Call call, IOException e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
