package com.example.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.domain.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(

) : ViewModel() {

    //region Get Screen
    private val _productState = MutableStateFlow<Product?>(null)
    val productState = _productState.asStateFlow()

    fun getProduct() {
        viewModelScope.launch {

        }
    }
    //endregion

}