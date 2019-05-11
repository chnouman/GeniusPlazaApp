package com.geniusplaza.app.ui.register;

import com.geniusplaza.app.data.DataManager;
import com.geniusplaza.app.ui.base.BasePresenter;
import com.geniusplaza.app.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class RegisterUserPresenter<V extends RegisterUserMvpView> extends BasePresenter<V> implements RegisterUserMvpPresenter<V> {


    @Inject
    public RegisterUserPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void registerUser(String name, String jobTitle) {
        //validate name and jobTilte
        if (name.trim().isEmpty() || jobTitle.trim().isEmpty()) {
            if (getMvpView() != null) {
                getMvpView().showToast("Fill the Form first");
                return;
            }
        }

        getCompositeDisposable().add(getDataManager().registerUser(name, jobTitle)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(usersResponse -> {

                    if (getMvpView() != null
                            && usersResponse != null
                            && usersResponse.getName() != null
                    ) {
                        getMvpView().showToast("Sign up Successfully");
                        getMvpView().resetFields();
                    }
                }, throwable -> {
                    if (getMvpView() != null) {
                        getMvpView().showToast(throwable.getMessage() + "");
                        getMvpView().hideLoading();
                    }
                })
        );
    }
}
