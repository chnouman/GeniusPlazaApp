package com.geniusplaza.app.ui.main;

import android.os.Bundle;
import com.geniusplaza.app.R;
import com.geniusplaza.app.ui.base.BaseActivity;
import javax.inject.Inject;
import butterknife.ButterKnife;

/**
 * Created by Muhammad Nouman
 */
public class MainActivity extends BaseActivity implements MainMvpView
        {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter.onAttach(this);
    }


    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

}
