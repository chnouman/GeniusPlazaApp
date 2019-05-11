package com.geniusplaza.app.data.remote;


import com.geniusplaza.app.data.remote.model.RegisterUserResponse;
import com.geniusplaza.app.data.remote.model.UsersResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiHelper {

    @GET("api/users")
    Observable<UsersResponse> getUsers();

    @FormUrlEncoded
    @POST("/api/users")
    Observable<RegisterUserResponse> registerUser(@Field("name") String name,@Field("job") String jobTitle);


}