package com.geniusplaza.app.ui.main;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class MainModule {


    @Provides
    MainMvpPresenter<MainMvpView> getScreenTimePresenter(MainPresenter<MainMvpView> screenTimePresenter) {
        return screenTimePresenter;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
