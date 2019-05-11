package com.geniusplaza.app.data.remote;


import com.geniusplaza.app.data.remote.model.RegisterUserResponse;
import com.geniusplaza.app.data.remote.model.UsersResponse;
import com.geniusplaza.app.utils.AppConstants;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class AppApiHelper implements ApiHelper {

    private static ApiHelper apiHelper = null;

    @Inject
    public AppApiHelper() {
    }

    private ApiHelper getClient() {

        if (apiHelper == null) {
            // creating an OkHttpClient that uses our SSLSocketFactory
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


            OkHttpClient client = new OkHttpClient
                    .Builder()
                    .addInterceptor(interceptor).build();
            return new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build().create(ApiHelper.class);

        }
        return apiHelper;
    }

    @Override
    public Observable<UsersResponse> getUsers() {
        return getClient().getUsers();
    }

    @Override
    public Observable<RegisterUserResponse> registerUser(String name,  String jobTitle) {
        return getClient().registerUser(name,jobTitle);
    }
}
