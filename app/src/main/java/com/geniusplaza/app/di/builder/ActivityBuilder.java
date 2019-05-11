package com.geniusplaza.app.di.builder;

import com.geniusplaza.app.ui.main.MainActivity;
import com.geniusplaza.app.ui.main.MainModule;
import com.geniusplaza.app.ui.register.RegisterUserActivity;
import com.geniusplaza.app.ui.register.RegisterUserModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract public MainActivity provideMainFactory();

    @ContributesAndroidInjector(modules = {RegisterUserModule.class})
    abstract public RegisterUserActivity provideRegisterUserFactory();
}

