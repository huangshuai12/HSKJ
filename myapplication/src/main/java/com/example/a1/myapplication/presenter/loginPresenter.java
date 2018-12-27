package com.example.a1.myapplication.presenter;

import com.example.a1.myapplication.activity.LoginActivity;
import com.example.a1.myapplication.entity.UserEntity;
import com.example.a1.myapplication.modle.LoginModel;
import com.example.a1.myapplication.net.RequestCallback;
import com.example.a1.myapplication.utils.ValidatorUtil;
import com.example.a1.myapplication.view.LoginView;

import java.util.HashMap;

public class loginPresenter {

    private LoginModel loginModel;
    private LoginView iloginView;

    public loginPresenter(LoginActivity iloginView){
        loginModel = new LoginModel();
        this.iloginView = iloginView;

    }


    public void login(HashMap<String,String> params) {
        //正则表达式校验

        String mobile ="18612991023";
        String password = "222222";
        if (!ValidatorUtil.isMobile(mobile)){
            if (iloginView!=null){
                iloginView.mobileError("请输入合法手机号");
            }
            return;//返回
        }

        //调用loginmodel的数据处理的方法，登录的方法
        if (loginModel!=null){
            loginModel.login(params, new RequestCallback() {
                @Override
                public void failure(String msg) {
                    if (iloginView!=null)
                        iloginView.failure(msg);
                }

                @Override
                public void successMsg(String msg) {
                    if (iloginView!=null)
                        iloginView.successMsg(msg);

                }

                @Override
                public void success(UserEntity userEntity) {
                    if (iloginView!=null)
                        iloginView.success(userEntity);

                }
            });
        }
    }
}
