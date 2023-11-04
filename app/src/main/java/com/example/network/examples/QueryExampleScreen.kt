package com.example.network.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.network.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QueryExampleScreen(viewModel: MainScreenViewModel, navigateBack: () -> Unit) {
    Scaffold(
        topBar = { AppBar(navigateBack) }
    ) {
        val textFieldValue by viewModel.inputTextField.collectAsState()
        val products by viewModel.productsState.collectAsState()
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            TextField(value = textFieldValue, onValueChange = viewModel::onInputText)
            LazyColumn {
                items(products) { product ->
                    Text("Title:")
                    Text(product.title)
                    Text("Description:")
                    Text(product.description + "\n")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(onBackPressClick: () -> Unit) {
    TopAppBar(
        title = { Text("Query example screen") },
        navigationIcon = {
            IconButton(onClick = onBackPressClick) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        }
    )
}