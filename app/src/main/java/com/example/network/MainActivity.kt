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
import com.example.network.coil.CoilExampleScreen
import com.example.network.examples.GetExampleScreen
import com.example.network.examples.PostExampleScreen
import com.example.network.examples.QueryExampleScreen
import com.example.network.ui.theme.NetworkTheme

class MainActivity : ComponentActivity() {

    lateinit var viewModel: MainScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Di().inject(this)
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
                                },
                                navigateToPostExample = {
                                    navController.navigate("PostExample")
                                },
                                navigateToQueryExample = {
                                    navController.navigate("QueryExample")
                                },
                                navigateToCoilExample = {
                                    navController.navigate("CoilExample")
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
                        composable(route = "PostExample") {
                            PostExampleScreen(
                                viewModel = viewModel
                            ) {
                                navController.popBackStack()
                            }
                        }
                        composable(route = "QueryExample") {
                            QueryExampleScreen(
                                viewModel = viewModel
                            ) {
                                navController.popBackStack()
                            }
                        }
                        composable(route = "CoilExample") {
                            CoilExampleScreen(
                                viewModel = viewModel
                            )
                        }
                    }
                }
            }
        }
    }
}