package com.geniusplaza.app.ui.main;


import com.geniusplaza.app.ui.base.MvpPresenter;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {


    void getUsers();
}
