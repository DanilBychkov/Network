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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.network.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostExampleScreen(viewModel: MainScreenViewModel, navigateBack: () -> Unit) {
    Scaffold(
        topBar = { AppBar(navigateBack) }
    ) {
        var login by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val user by viewModel.userState.collectAsState()
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
        )
        {
            Text(text = "Login: ")
            TextField(
                value = login,
                onValueChange = { value -> login = value }
            )
            Text(text = "Password: ")
            TextField(
                value = password,
                onValueChange = { value -> password = value }
            )
            Button(onClick = { viewModel.auth(login, password) }) {
                Text(text = "LogIn")
            }
            Spacer(modifier = Modifier.height(8.dp))
            user?.let { user ->
                Text(text = "User name: ${user.firstName}")
                Spacer(modifier = Modifier.height(8.dp))
            }
            Text(text = "User Example: atuny0, 9uQFF1Lh")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(onBackPressClick: () -> Unit) {
    TopAppBar(
        title = { Text("Post example screen") },
        navigationIcon = {
            IconButton(onClick = onBackPressClick) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        }
    )
}