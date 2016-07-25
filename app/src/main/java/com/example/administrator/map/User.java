package com.example.administrator.map;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class User {
    @SerializedName("UserName")
    private String name;
    @SerializedName("Password")
    private String password;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
