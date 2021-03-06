package com.nhom12.rau_cu_xanh.network

import com.nhom12.rau_cu_xanh.model.Product
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private val BASE_URL = getBaseUrl()

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
    // add params to url ex : http://192.168.1.35:5000/home
    @GET("home") //send GET request to server
    suspend fun getProduct() : List<Product>

    @GET("raucuinfo/{product_id}") //send GET request to server
    suspend fun getProductInfo(@Path("product_id") id: String) : List<Product>

}

object ProductApi {
    val retrofitService : ProductCallApi by lazy {
        retrofit.create(ProductCallApi::class.java) }
}