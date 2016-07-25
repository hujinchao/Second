package com.example.administrator.map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
@OnClick({R.id.main_login,R.id.main_register})
public void onClick(View view){
    int id=view.getId();
    Class cls=null;
    if(id==R.id.main_login){
        cls=LoginActivity.class;

    }else if(id==R.id.main_register){
        cls=RegisterActivity.class;
    }
    Intent intent=new Intent(this,cls);
    startActivity(intent);
}
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
