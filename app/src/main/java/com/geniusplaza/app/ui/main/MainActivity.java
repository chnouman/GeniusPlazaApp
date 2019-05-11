package com.geniusplaza.app.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geniusplaza.app.R;
import com.geniusplaza.app.adapters.UsersAdapter;
import com.geniusplaza.app.data.remote.model.User;
import com.geniusplaza.app.ui.base.BaseActivity;
import com.geniusplaza.app.ui.register.RegisterUserActivity;
import com.geniusplaza.app.utils.ViewAnimation;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.geniusplaza.app.utils.AppConstants.LOADING_DURATION;

/**
 * Created by Muhammad Nouman
 */
public class MainActivity extends BaseActivity implements MainMvpView, UsersAdapter.UsersInterface {


    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.retryButton)
    AppCompatButton retryButton;

    @BindView(R.id.errorMessageTV)
    TextView errorMessageTV;
    @BindView(R.id.lytProgress)
    LinearLayout lytProgress;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    UsersAdapter usersAdapter;

    @Inject
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.onAttach(this);
        setUnBinder(ButterKnife.bind(this));

        getSupportActionBar().setElevation(8);
        fetchData();
    }

    private void fetchData() {
        //fetch data
        if (isNetworkConnected()) {
            showLoading();
        } else {
            onErrorLayout();
        }
    }

    @Override
    public void onErrorLayout() {
        errorMessageTV.setText(R.string.retry_text);
        progressBar.setVisibility(View.GONE);
        retryButton.setVisibility(View.VISIBLE);
        errorMessageTV.setVisibility(View.VISIBLE);
        lytProgress.setVisibility(View.VISIBLE);

    }


    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        retryButton.setVisibility(View.GONE);
        errorMessageTV.setText(R.string.getting_users);
        errorMessageTV.setVisibility(View.VISIBLE);
        lytProgress.setVisibility(View.VISIBLE);
        lytProgress.setAlpha(1.0f);
        recyclerView.setVisibility(View.GONE);
        new Handler().postDelayed(() -> ViewAnimation.fadeOut(lytProgress), LOADING_DURATION);

        new Handler().postDelayed(() -> setupRecyclerView(), LOADING_DURATION + 400);
    }

    @Override
    public void hideLoading() {

        lytProgress.setVisibility(View.GONE);
    }

    private void setupRecyclerView() {
        recyclerView.setVisibility(View.VISIBLE);
        usersAdapter.setUsersInterface(this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(usersAdapter);
        mPresenter.getUsers();
    }

    @Override
    public void onReceiveUsers(List<User> users) {
        hideLoading();
        usersAdapter.addAll(users);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onUserClick(User user, int position) {
        showToast(user.getFirstName() + " " + getString(R.string.user_click_message));
    }

    @Override
    public void onUserLongPress(User user, int position) {
        showToast(getString(R.string.user_long_click_message));
    }

    @OnClick(R.id.retryButton)
    void onRetry() {
        fetchData();
    }

    @OnClick(R.id.registerButton)
    void onRegisterButtonClick() {
        startActivity(RegisterUserActivity.getStartingIntent(MainActivity.this));
    }
}
