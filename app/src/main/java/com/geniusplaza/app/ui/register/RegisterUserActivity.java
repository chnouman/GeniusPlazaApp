package com.geniusplaza.app.ui.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.geniusplaza.app.R;
import com.geniusplaza.app.ui.base.BaseActivity;
import com.geniusplaza.app.utils.AppConstants;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.geniusplaza.app.utils.AppConstants.SAVED_JOB;
import static com.geniusplaza.app.utils.AppConstants.SAVED_NAME;

/**
 * Created by Muhammad Nouman
 */
public class RegisterUserActivity extends BaseActivity implements RegisterUserMvpView {


    @Inject
    RegisterUserMvpPresenter<RegisterUserMvpView> mPresenter;


    @BindView(R.id.nameATV)
    AppCompatAutoCompleteTextView nameATV;

    @BindView(R.id.jobET)
    AppCompatEditText jobET;

    @BindView(R.id.registerButton)
    AppCompatButton registerButton;

    @BindView(R.id.lytProgressMain)
    RelativeLayout lytProgressMain;


    @BindView(R.id.errorMessageTV)
    TextView errorMessageTV;

    @BindView(R.id.loginForm)
    ScrollView loginForm;


    public static Intent getStartingIntent(Context context) {
        return new Intent(context, RegisterUserActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mPresenter.onAttach(this);
        setUnBinder(ButterKnife.bind(this));

        errorMessageTV.setText(R.string.registering_user);

        if (savedInstanceState != null) {
            String name = (String) savedInstanceState.get(SAVED_NAME);
            String job = (String) savedInstanceState.get(AppConstants.SAVED_JOB);
            nameATV.setText(name != null ? name : "");
            jobET.setText(job != null ? job : "");
        }


    }


    @Override
    public void onErrorLayout() {

    }

    private void showProgress(final boolean show) {
        lytProgressMain.setVisibility(show ? View.VISIBLE : View.GONE);
        loginForm.setVisibility(show ? View.GONE : View.VISIBLE);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        showProgress(false);
    }


    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @OnClick(R.id.registerButton)
    void registerUser() {
        if (isNetworkConnected()) {

            showProgress(true);
            mPresenter.registerUser(nameATV.getText().toString(), jobET.getText().toString());
        } else {
            showToast(getString(R.string.network_disconnected));
        }
    }

    @OnClick(R.id.backButton)
    void backButton() {
        finish();
    }

    @Override
    public void resetFields() {
        showProgress(false);
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(SAVED_NAME, nameATV.getText().toString());
        outState.putString(AppConstants.SAVED_JOB, jobET.getText().toString());
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            String name = (String) savedInstanceState.get(SAVED_NAME);
            nameATV.setText(name != null ? name : "");
            String job = (String) savedInstanceState.get(SAVED_JOB);
            jobET.setText(job != null ? job : "");
        }
    }

}
