package com.example.a1.huangshuaimvp.model;

import android.os.Handler;
import android.telecom.Call;

import com.example.a1.huangshuaimvp.bean.UserBean;
import com.example.a1.huangshuaimvp.contract.Logincontract;
import com.example.a1.huangshuaimvp.net.ResponceCallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginModel implements Logincontract.ILoginModel {
    //Handler 机制
    Handler handler = new Handler();

    @Override
    public void setokhttp(HashMap<String,String> map, String string, final ResponceCallBack callBack) {
        //okhttp网络请求框架
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        //请求体
        FormBody.Builder builder = new FormBody.Builder();
        for(Map.Entry<String,String> p:map.entrySet()){
            builder.add(p.getKey(),p.getValue());
        }
        //请求
        Request request = new Request.Builder().url(string).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.fail("网络连接超时");
                    }
                });
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                String result = response.body().string();
                //判断响应码
                if (200==response.code()){
                    //解析数据的方法
                    getjson(result,callBack);
                }

        }
    });
}

    /**
     * 解析数据的方法
     * @param string
     * @param callBack
     */
    private void getjson(String string, final ResponceCallBack callBack){
        //开始解析
        final UserBean userBean = new Gson().fromJson(string, UserBean.class);
        //通过接口传递数据
        if (userBean!=null){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callBack.success(userBean);
                }
            });
        }
    }
}
