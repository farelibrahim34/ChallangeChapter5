package com.example.chapter5.network

import com.example.chapter5.model.DataMahasiswa
import com.example.chapter5.model.ResponseDataMhs
import com.example.chapter5.model.ResponseDataMhsItem
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @GET("datamhs")
    fun getAllDataMhs() : Call<List<ResponseDataMhsItem>>

    @GET("datamhs/{id}")
    fun getDataByid(@Path("id") id : Int): Call<ResponseDataMhsItem>

    @PUT("datamhs/{id}")
    fun editDataMhs(@Path("id") id: Int,@Body request : DataMahasiswa): Call<ResponseDataMhsItem>

    @POST("datamhs")
    fun addDataMhs(@Body request : DataMahasiswa): Call<ResponseDataMhs>

    @DELETE("datamhs/{id}")
    fun deleteDataMhs(@Path("id")id : Int): Call<ResponseDataMhsItem>

}