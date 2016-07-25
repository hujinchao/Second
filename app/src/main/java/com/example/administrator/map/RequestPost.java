package com.example.administrator.map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class RequestPost {
public static String Url="http://admin.syfeicuiedu.com";

    public static void setPost(String name, String pwd,String getUrl){
        final Gson gson = new Gson();
        User user = new User(name,pwd);
        OkHttpClient client = new OkHttpClient();
        String coent = gson.toJson(user);
        MediaType JSON = MediaType.parse("Map/json");
        RequestBody requestBody = RequestBody.create(JSON, coent);
        Request request = new Request.Builder()
                .url(Url+getUrl)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json=response.body().string();
                    Log.e("aa",response.message());
                    Register register=gson.fromJson(json,Register.class);
                    Log.e("aa",register.getErrmsg());
                }
            }
        });
    }
}
