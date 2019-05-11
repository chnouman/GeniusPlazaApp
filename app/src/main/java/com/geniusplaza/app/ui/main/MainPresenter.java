package com.geniusplaza.app.ui.main;

import com.geniusplaza.app.data.DataManager;
import com.geniusplaza.app.ui.base.BasePresenter;
import com.geniusplaza.app.utils.rx.SchedulerProvider;
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


}
