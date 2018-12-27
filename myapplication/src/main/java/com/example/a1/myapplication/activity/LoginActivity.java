package com.example.a1.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a1.myapplication.R;
import com.example.a1.myapplication.entity.UserEntity;
import com.example.a1.myapplication.presenter.loginPresenter;
import com.example.a1.myapplication.view.LoginView;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private loginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        presenter = new loginPresenter(this);
    }

    /**
     * 点击，登录
     * @param view
     */
    public void login(View view) {

        HashMap<String,String> params = new HashMap<>();
        params.put("mobile","18612991023");
        params.put("password","222222");

        if (presenter!=null){
            presenter.login(params);
        }

    }

    @Override
    public void mobileError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(UserEntity userEntity) {
//        String uid = userEntity.data.uid;
        Toast.makeText(this,userEntity.msg+"",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void successMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
