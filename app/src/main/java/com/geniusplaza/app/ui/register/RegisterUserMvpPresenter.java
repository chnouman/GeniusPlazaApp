package com.geniusplaza.app.ui.register;


import com.geniusplaza.app.ui.base.MvpPresenter;

public interface RegisterUserMvpPresenter<V extends RegisterUserMvpView> extends MvpPresenter<V> {


    void registerUser(String name, String jobTitle);
}
