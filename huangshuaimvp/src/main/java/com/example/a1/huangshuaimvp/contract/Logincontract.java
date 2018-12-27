package com.example.a1.huangshuaimvp.contract;

import com.example.a1.huangshuaimvp.bean.UserBean;
import com.example.a1.huangshuaimvp.net.ResponceCallBack;

import java.util.HashMap;

public interface Logincontract {
    public abstract class ILogpresenter{
        public abstract void login(HashMap<String,String> map);
        public abstract void reg(HashMap<String,String> map);
    }

    public interface ILoginModel{
        void setokhttp(HashMap<String,String> map, String string, ResponceCallBack callBack);
    }

    public interface IloginView{
        public void success(UserBean userBean);
        public void fail(String string);
        public void mobileerror(String error);
    }
}
