package com.aexample.todoapp.network

import com.aexample.todoapp.models.ResponseModel
import retrofit2.http.GET

interface ApiInterface {

    @GET("/v2/5a8e5b372f000048004f25fc")
    fun getDataList():ArrayList<ResponseModel>
}