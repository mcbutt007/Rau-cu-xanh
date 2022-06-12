package com.nhom12.rau_cu_xanh.network

import com.nhom12.rau_cu_xanh.model.Product
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "http://192.168.42.55:5000/"

/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * The Retrofit object with the Moshi converter.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ProductCallApi {
    // add params to url ex : http://192.168.1.35:5000/login?username=Teo&password=123
    @GET("home") //send GET request to server
    suspend fun getProduct() : List<Product>

}
fun getBaseUrl(): String {
    return BASE_URL
}

object ProductApi {
    val retrofitService : ProductCallApi by lazy {
        retrofit.create(ProductCallApi::class.java) }
}