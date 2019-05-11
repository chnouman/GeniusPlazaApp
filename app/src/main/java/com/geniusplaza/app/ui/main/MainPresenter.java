package com.geniusplaza.app.ui.main;

import com.geniusplaza.app.data.DataManager;
import com.geniusplaza.app.data.remote.model.User;
import com.geniusplaza.app.ui.base.BasePresenter;
import com.geniusplaza.app.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {


    @Inject
    public MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void getUsers() {
        getCompositeDisposable().add(getDataManager().getUsers()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(usersResponse -> {

                    if (getMvpView() != null
                            && usersResponse != null
                            && usersResponse.getData() != null
                            && usersResponse.getData().size() > 0) {
                        getMvpView().onReceiveUsers(usersResponse.getData());
                    }
                }, throwable -> {
                    if (getMvpView() != null) {
                        getMvpView().showToast(throwable.getMessage()+"");
                    }
                })
        );
    }
}
