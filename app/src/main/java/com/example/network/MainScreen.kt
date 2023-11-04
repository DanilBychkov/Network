package com.example.network

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(
    navigateToGetExample: () -> Unit,
    navigateToPostExample: () -> Unit,
    navigateToQueryExample: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Retrofit example project", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = navigateToGetExample) {
            Text(text = "Get + Path request example")
        }
        Button(onClick = navigateToPostExample) {
            Text(text = "Post + Body + Header request example")
        }
        Button(onClick = navigateToQueryExample) {
            Text(text = "Query + List request example")
        }
    }
}