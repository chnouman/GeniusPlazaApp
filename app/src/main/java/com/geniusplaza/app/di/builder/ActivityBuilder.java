package com.geniusplaza.app.di.builder;

import android.app.LauncherActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {ServiceModule.class})
    abstract public UsageReaderService bindUsageService();

    @ContributesAndroidInjector(modules = {ForegroundAppServiceModule.class})
    abstract public ForegroundAppService bindForegroundAppService();

    @ContributesAndroidInjector(modules = {NotificationListenerModule.class})
    abstract public NotificationListener bindNotificationListener();

    @ContributesAndroidInjector()
    abstract public LauncherActivity provideLauncherFactory();

    @ContributesAndroidInjector(modules = {BrowserModule.class})
    abstract public BrowserActivity provideBrowserFactory();

    @ContributesAndroidInjector(modules = {PrivacyDialogModule.class})
    abstract public PrivacyPopUp providePrivacyDialog();



    @ContributesAndroidInjector(modules = {TakeBreakModule.class})
    abstract public TakeBreakActivity bindTakeBreakActivity();
}

