package com.example.a1.huangshuaimvp.presenter;

import com.example.a1.huangshuaimvp.api.UserApi;
import com.example.a1.huangshuaimvp.bean.UserBean;
import com.example.a1.huangshuaimvp.contract.Logincontract;
import com.example.a1.huangshuaimvp.model.LoginModel;
import com.example.a1.huangshuaimvp.net.ResponceCallBack;
import com.example.a1.huangshuaimvp.utils.ValidatorUtil;

import java.util.HashMap;

public class LogPresenter extends Logincontract.ILogpresenter {
    private LoginModel loginModel;
    private Logincontract.IloginView iloginView;
    public LogPresenter(Logincontract.IloginView iloginView) {
        loginModel = new LoginModel();
        this.iloginView = iloginView;
    }

    //登录的方法
    @Override
    public void login(HashMap<String, String> map) {
        String mobile= map.get("mobile");
        if (!ValidatorUtil.isMobile(mobile)){
            iloginView.mobileerror("手机号不合法");
            return;
        }
        loginModel.setokhttp(map, UserApi.USER_LOGIN, new ResponceCallBack() {
            @Override
            public void success(UserBean userBean) {
                if (userBean!=null){
                    iloginView.success(userBean);
                }
            }

            @Override
            public void fail(String string) {
                iloginView.fail(string);
            }
        });
    }


    //注册的方法
    @Override
    public void reg(HashMap<String,String> map) {
        String mobile= map.get("mobile");
        if (!ValidatorUtil.isMobile(mobile)){
            iloginView.mobileerror("手机号不合法");
            return;
        }
        loginModel.setokhttp(map, UserApi.USER_REG, new ResponceCallBack() {
            @Override
            public void success(UserBean userBean) {
                if (userBean!=null){
                    iloginView.success(userBean);
                }
            }
            @Override
            public void fail(String string) {
                iloginView.fail(string);
            }
        });
    }
}

