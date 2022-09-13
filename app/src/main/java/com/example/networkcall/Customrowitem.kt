package com.example.networkcall

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.networkcall.Retrofit.Model
import com.example.networkcall.Retrofit.RetrofitViewModel

@Composable
fun getusers(model: Model){

    Row() {

        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(8.dp, 4.dp)
                .fillMaxWidth()
                .height(110.dp)
            , shape = RoundedCornerShape(8.dp), elevation = 4.dp
        ) {

            Text(text = model.username)
            Text(text = model.password)
            Text(text = model.email)

        }

    }
}
