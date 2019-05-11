package com.geniusplaza.app.ui.register;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class RegisterUserModule {


    @Provides
    RegisterUserMvpPresenter<RegisterUserMvpView> getRegisterUserPresenter(RegisterUserPresenter<RegisterUserMvpView> registerUserPresenter) {
        return registerUserPresenter;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
