package com.geniusplaza.app.ui.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.geniusplaza.app.utils.NetworkUtils;

import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {


    private Unbinder mUnBinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDI();
        super.onCreate(savedInstanceState);
    }


    protected void performDI() {
        AndroidInjection.inject(this);
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }


    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {
        hideLoading();
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }



    @Override
    public void showToast(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }
}
