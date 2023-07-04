package com.gaur.composenewsapplication.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.gaur.composenewsapplication.data.model.loginresponse.User
import com.gaur.composenewsapplication.domain.model.Article
import com.gaur.composenewsapplication.presentation.viewmodel.LoginViewModel
import com.gaur.composenewsapplication.presentation.viewmodel.NewsViewModel


@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel()) {

    val res = viewModel.login.value


    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize())
        {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = res.error, modifier = Modifier.align(Alignment.Center))
        }

    }


    res.data?.let {
        Log.d("H_TAG", "LoginScreen: $it")
        UserItem(it)
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        Button(
            onClick = {
                viewModel.loginUserFunction()
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(0.8f)
                .wrapContentHeight()
        ) {
            Text(text = "Click to Login in")
        }
    }



}

@Composable
fun UserItem(it: User) {

    Column(modifier = Modifier) {

        Image(
            painter = rememberImagePainter(data = it.image), contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop

        )

        Text(
            text = it.name, style = androidx.compose.ui.text.TextStyle(
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold, fontSize = 20.sp
            ),
            modifier = Modifier.padding(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

    }


}


