package com.nhom12.rau_cu_xanh.network

import android.database.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

private const val BASE_URL =
    "http://192.168.42.158:5000/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface LoginApiService {


    // add params to url ex : http://192.168.1.35:5000/login?username=Teo&password=123
    @POST("login") //send POST request to server
    suspend fun sendLoginInfo(
        @Query("username") username: String,
        @Query("password") password: String
    ) : Int

    // ex: http://192.168.1.35:5000/login?email=example@gmail.com
    @POST("resetpassword")
    suspend fun sendEmailResetPassword(
        @Query("email") email : String
    ) : String

    // ex: http://192.168.1.35:5000/registration?username=Phuc&email=phuc@gmail.com&password=123456
    @POST("registration")
    suspend fun sendRegistrationInfo(
        @Query("username") username : String,
        @Query("email") email : String,
        @Query("password") password : String
    ) : String
}

object LoginApi {
    val retrofitService : LoginApiService by lazy {
        retrofit.create(LoginApiService::class.java) }
}