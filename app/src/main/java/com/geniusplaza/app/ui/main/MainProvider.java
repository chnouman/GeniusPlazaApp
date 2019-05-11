package com.geniusplaza.app.ui.main;

import com.geniusplaza.app.adapters.UsersAdapter;
import com.geniusplaza.app.di.PerActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainProvider {

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity provideMainFactory();

}
