package com.aexample.todoapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
    val baseUrl = "http://www.mocky.io"
    private var retrofit:Retrofit? = null
    private var newApiInterface:ApiInterface? = null

    val apiInterface: ApiInterface?
    get() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        retrofit = Retrofit.Builder().
        baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        if(newApiInterface!=null){
            newApiInterface = retrofit?.create(ApiInterface::class.java)
        }

        return apiInterface
    }



}