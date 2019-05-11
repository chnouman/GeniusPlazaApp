package com.geniusplaza.app.ui.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainProvider {

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity provideMainFactory();
}
