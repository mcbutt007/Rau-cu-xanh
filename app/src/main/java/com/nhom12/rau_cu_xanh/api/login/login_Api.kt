package com.nhom12.rau_cu_xanh.api.login

import android.widget.TextView
import com.nhom12.rau_cu_xanh.model.Books
import com.nhom12.rau_cu_xanh.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface login_Api {

    companion object {
        var BASE_URL = "http://35.184.157.153:5000/"

            val ApiService = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(login_Api::class.java)

//        private val retrofit by lazy {
//            Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//        val api: login_Api by lazy {
//            retrofit.create(login_Api::class.java)
//        }


    }

//
//    @GET("volley_array.json")
//    fun getMovies() : Call<List<Movie>>

//    @GET("api/v1/resources/books")
//    fun getMovies() : Call<List<User>>


    @GET("api/v1/resources/books")
    fun getBook_id(@Query("id") id: Int): Call<Array<Books>>
    @GET("User")
    fun getUser(@Query("ID") ID: Int): Call<Array<User>>

    @GET("User/User_name")
    fun getUser_via_UserName(@Query("user_name") user_name: String): Call<Array<User>>

}



