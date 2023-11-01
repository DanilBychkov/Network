package com.example.network

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.network.examples.GetExampleScreen
import com.example.network.ui.theme.NetworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = Di().provideMainScreenViewModel()

        setContent {
            NetworkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable(route = "MainScreen") {
                            MainScreen(
                                navigateToGetExample = {
                                    navController.navigate("GetExample")
                                }
                            )
                        }
                        composable(route = "GetExample") {
                            GetExampleScreen(
                                viewModel = viewModel
                            ) {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}