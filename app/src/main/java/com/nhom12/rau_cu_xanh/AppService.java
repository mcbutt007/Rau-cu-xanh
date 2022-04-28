package com.nhom12.rau_cu_xanh;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AppService
{// https://jsonplaceholder.typicode.com/posts
    //http://restapi.adequateshop.com/api/Tourist?page=1
    Gson gson=new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    AppService apiService =new Retrofit.Builder()
            .baseUrl("http://restapi.adequateshop.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(AppService.class);


    @GET("Tourist")
    Call<User> getlist(@Query("page") String key);
}
