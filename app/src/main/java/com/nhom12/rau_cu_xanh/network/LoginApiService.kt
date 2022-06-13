package com.nhom12.rau_cu_xanh.network

//Phục vụ login

import android.database.Observable
import android.provider.SyncStateContract
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

private val BASE_URL = getBaseUrl()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface LoginApiService {

    // Chỉ cần chú ý những thứ trong interface này

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


    // mua hàng, insert vào bảng RECIEPT
    @POST("muahang")
    suspend fun muahang(
        @Query("userid") userid: String,
        @Query("raucuid") raucuid: String
    ) : String
}

object LoginApi {
    val retrofitService : LoginApiService by lazy {
        retrofit.create(LoginApiService::class.java) }
}