package com.geniusplaza.app.ui.main;


import com.geniusplaza.app.data.remote.model.User;
import com.geniusplaza.app.ui.base.MvpView;

import java.util.List;

public interface MainMvpView extends MvpView {


    void onReceiveUsers(List<User> data);
}
