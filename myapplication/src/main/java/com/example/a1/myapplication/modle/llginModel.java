package com.example.a1.myapplication.modle;

import com.example.a1.myapplication.net.RequestCallback;

import java.util.HashMap;

public abstract class llginModel {
    abstract void login(HashMap<String, String> params, RequestCallback requestCallback);


}
