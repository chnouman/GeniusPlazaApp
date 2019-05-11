package com.geniusplaza.app.ui.base;

/**
 * Created by Muhammad Nouman
 */


/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError();

    boolean isNetworkConnected();

    void showToast(String message);

}
