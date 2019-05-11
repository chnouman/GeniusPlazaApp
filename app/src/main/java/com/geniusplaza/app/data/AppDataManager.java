package com.geniusplaza.app.data;

import android.content.Context;
import com.geniusplaza.app.data.prefs.PreferencesHelper;
import com.geniusplaza.app.data.remote.ApiHelper;
import com.geniusplaza.app.data.remote.model.RegisterUserResponse;
import com.geniusplaza.app.data.remote.model.UsersResponse;
import com.geniusplaza.app.di.ApplicationContext;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager {


    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }


    @Override
    public Observable<UsersResponse> getUsers() {
        return mApiHelper.getUsers();
    }

    @Override
    public Observable<RegisterUserResponse> registerUser(String name, String jobTitle) {
        return mApiHelper.registerUser(name,jobTitle);
    }
}
