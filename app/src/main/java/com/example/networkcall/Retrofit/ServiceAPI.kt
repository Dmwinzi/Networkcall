package com.example.networkcall.Retrofit

import androidx.lifecycle.LiveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT


interface ServiceAPI {

    @GET("/fetchall")
    suspend fun getusers () : List<Model>

    @POST("/save")
    suspend fun insertuser(@Body insertModel: InsertModel)


     companion object{
         private  var instance:ServiceAPI ? = null

         fun getRetrofiinstance():ServiceAPI{

             if(instance == null){
                 instance  = Retrofit.Builder()
                     .addConverterFactory(GsonConverterFactory.create())
                     .baseUrl("http://192.168.43.69:8080")
                     .build().create(ServiceAPI::class.java)
             }
             return instance!!
         }


     }

}