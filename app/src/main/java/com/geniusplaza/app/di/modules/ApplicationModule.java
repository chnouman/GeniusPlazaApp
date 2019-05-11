package com.geniusplaza.app.di.modules;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geniusplaza.app.GeniusPlazaApp;
import com.geniusplaza.app.adapters.UsersAdapter;
import com.geniusplaza.app.data.AppDataManager;
import com.geniusplaza.app.data.DataManager;
import com.geniusplaza.app.data.prefs.AppPreferencesHelper;
import com.geniusplaza.app.data.prefs.PreferencesHelper;
import com.geniusplaza.app.data.remote.ApiHelper;
import com.geniusplaza.app.data.remote.AppApiHelper;
import com.geniusplaza.app.di.ApplicationContext;
import com.geniusplaza.app.di.PerActivity;
import com.geniusplaza.app.di.PerAppCompositDisposible;
import com.geniusplaza.app.di.PreferenceInfo;
import com.geniusplaza.app.utils.rx.AppSchedulerProvider;
import com.geniusplaza.app.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

import static com.geniusplaza.app.utils.AppConstants.Preference.PREFERENCE_NAME;

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
    CompositeDisposable getCompositeDisposable() {
        return new CompositeDisposable();
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
    PreferencesHelper getPreferenceHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper getAPiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Singleton
    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
    }

}
