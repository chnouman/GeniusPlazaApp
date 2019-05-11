package com.geniusplaza.app.di.modules;

import android.content.Context;

import com.geniusplaza.app.GeniusPlazaApp;
import com.geniusplaza.app.di.ApplicationContext;
import com.geniusplaza.app.di.DatabaseInfo;
import com.geniusplaza.app.di.InstabugKey;
import com.geniusplaza.app.di.PerAppCompositDisposible;
import com.geniusplaza.app.di.PreferenceInfo;
import com.geniusplaza.app.utils.rx.AppSchedulerProvider;
import com.geniusplaza.app.utils.rx.SchedulerProvider;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ApplicationModule {

    private GeniusPlazaApp geniusPlazaApp;

    public ApplicationModule(GeniusPlazaApp geniusPlazaApp) {
        this.geniusPlazaApp = geniusPlazaApp;
    }

    @Provides
    @Singleton
    @ApplicationContext
    public Context getApplicationContext() {
        return geniusPlazaApp;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerAppCompositDisposible
    CompositeDisposable getCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    @DatabaseInfo
    @Singleton
    public String getDataBaseName() {
        return DATABASE_NAME;
    }


    @Provides
    @InstabugKey
    @Singleton
    public String getInstaBugKey() {
        return INSTA_BUG_KEY;
    }

    @Provides
    @PreferenceInfo
    @Singleton
    public String getPreferenceName() {
        return PREFERENCE_NAME;
    }


    @Provides
    @Singleton
    DataManager getDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    @Singleton
    DbHelper getDBHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper getPreferenceHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper getAPiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


}
