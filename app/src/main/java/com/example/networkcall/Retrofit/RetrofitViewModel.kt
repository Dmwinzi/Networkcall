package com.example.networkcall.Retrofit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RetrofitViewModel : ViewModel() {

 var userlist : List<Model> by mutableStateOf(listOf())
    val  serviceAPI = ServiceAPI.getRetrofiinstance()
 fun getusers(){

     viewModelScope.launch {
         var allusers  = serviceAPI.getusers()
         userlist = allusers

     }

 }

 fun insertuser(insertModel: InsertModel){
     viewModelScope.launch {
         var insert = serviceAPI.insertuser(insertModel)
     }
 }


}