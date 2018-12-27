package com.example.a1.huangshuaimvp.net;

import com.example.a1.huangshuaimvp.bean.UserBean;

public interface ResponceCallBack {
    void success(UserBean userBean);
    void fail(String string);
}
