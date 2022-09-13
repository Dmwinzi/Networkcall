package com.example.networkcall

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.networkcall.Retrofit.Model
import com.example.networkcall.Retrofit.RetrofitViewModel
import com.example.networkcall.Retrofit.ServiceAPI
import com.example.networkcall.ui.theme.NetworkCallTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
               val retrofitViewModel  by viewModels<RetrofitViewModel>()
        setContent {
            NetworkCallTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    var allusers  = retrofitViewModel.userlist
                    retrofitViewModel.getusers()

                    showusers(retrofitViewModel = retrofitViewModel)
                     
                }
            }
        }
    }

}


@Composable
fun showusers(retrofitViewModel: RetrofitViewModel){

    var  context = LocalContext.current
    retrofitViewModel.userlist
    var alluserslist = retrofitViewModel.getusers()

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "network call")}) },


        content = {
            LazyColumn( content = {
                items(items = retrofitViewModel.userlist, itemContent = {
                    Card(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(8.dp, 4.dp)
                            .fillMaxWidth()
                            .height(110.dp)
                        , shape = RoundedCornerShape(8.dp), elevation = 4.dp
                    ) {
                        Text(text = it.username, modifier = Modifier.padding(top = 20.dp, start = 20.dp))
                        Text(text = it.email,modifier = Modifier.padding(top = 50.dp, start = 20.dp))
                        Text(text = it.password,modifier = Modifier.padding(top = 70.dp, start = 20.dp))
                        
                    }
                })
            })
        }

    )

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NetworkCallTheme {

    }
}