package com.example.a1.myapplication.view;

import com.example.a1.myapplication.entity.UserEntity;

public interface LoginView {
    void mobileError(String msg);
    void pwdError(String msg);
    void failure(String msg);
    void success(UserEntity userEntity);
    void successMsg(String msg);
}
