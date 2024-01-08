package com.example.network.coil

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.network.MainScreenViewModel


@Composable
fun CoilExampleScreen(
    viewModel: MainScreenViewModel
) {
    Column {
        val imageRequest = ImageRequest
            .Builder(LocalContext.current)
            .data("https://mediasole.ru/data/images/0/44845/1_09.jpg")
            .crossfade(1000)
            .build()

        AsyncImage(
            model = imageRequest,
            contentDescription = null
        )
        SubcomposeAsyncImage(
            model = "https://mediasole.ru/data/images/0/44845/1_09.jpg",
            contentDescription = null
        )
    }
}