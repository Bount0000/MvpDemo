package com.example.lenovo.mvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView tv_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        Intent intent = getIntent();
        String phone = intent.getStringExtra("phone");
        tv_phone.setText(phone);

    }

    private void initView() {
     tv_phone = (TextView) findViewById(R.id.tv_phone);
    }
}
