package com.geniusplaza.app.ui.main;

import com.geniusplaza.app.adapters.UsersAdapter;
import com.geniusplaza.app.di.PerActivity;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class MainModule {


    @Provides
    MainMvpPresenter<MainMvpView> getMainPresenter(MainPresenter<MainMvpView> mainPresenter) {
        return mainPresenter;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    UsersAdapter provideUserAdapter() {
        return new UsersAdapter();
    }
}
