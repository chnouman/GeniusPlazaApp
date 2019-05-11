package com.geniusplaza.app;

import android.app.Activity;
import android.app.Application;

import com.geniusplaza.app.di.components.DaggerApplicationComponent;
import com.geniusplaza.app.di.modules.ApplicationModule;
import com.geniusplaza.app.utils.logs.AppLogger;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.plugins.RxJavaPlugins;

public class GeniusPlazaApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder()
                .application(this)
                .applicationModule(new ApplicationModule(this))
                .build().inject(this);

        RxJavaPlugins.setErrorHandler(error -> {
            if (error instanceof UndeliverableException) {
                AppLogger.e("onCreate: " + error.getMessage());
            }else {
                error.printStackTrace();
            }

        });
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

}
