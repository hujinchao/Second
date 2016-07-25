package com.example.administrator.map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.login_name)
    EditText get_name;
    @Bind(R.id.login_pwd)
    EditText get_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_sure)
    public void onClick() {
        String name = get_name.getText().toString();
        String pwd = get_pwd.getText().toString();
        RequestPost.setPost(name,pwd,"/Handler/UserHandler.ashx?action=login");
        Intent intent;
        intent = new Intent(this,MapActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
