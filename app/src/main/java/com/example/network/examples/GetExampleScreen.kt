package com.example.network.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.network.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetExampleScreen(viewModel: MainScreenViewModel, navigateBack: () -> Unit) {
    Scaffold(
        topBar = { AppBar(navigateBack) }
    ) {
        val product by viewModel.productState.collectAsState()
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Hello from GetExample Screen")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { viewModel.getProduct() }) {
                Text(text = "Load Product")
            }
            Spacer(modifier = Modifier.height(8.dp))
            product?.let {
                Text(text = "Product name: ${it.title}")
                Text(text = "Product description: ${it.description}")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(onBackPressClick: () -> Unit) {
    TopAppBar(
        title = { Text("Get example screen") },
        navigationIcon = {
            IconButton(onClick = onBackPressClick) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        }
    )
}