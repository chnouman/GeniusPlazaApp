package com.geniusplaza.app.data.remote;


import com.geniusplaza.app.data.remote.model.RegisterUserResponse;
import com.geniusplaza.app.data.remote.model.UsersResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiHelper {

    @POST("api/users")
    Observable<UsersResponse> getUsers();

    @POST("/api/users")
    Observable<RegisterUserResponse> registerUser(@Body Map<String, Object> params);


}