package com.example.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.data.Repository
import com.example.network.domain.AuthRequest
import com.example.network.domain.Product
import com.example.network.domain.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val repository: Repository
) : ViewModel() {

    //region Get Screen
    private val _productState = MutableStateFlow<Product?>(null)
    val productState = _productState.asStateFlow()

    fun getProduct(id: Int) {
        viewModelScope.launch {
            _productState.value = repository.getProduct(id)
        }
    }
    //endregion

    //region Post Screen
    private val _userState = MutableStateFlow<User?>(null)
    val userState = _userState.asStateFlow()

    fun auth(login: String, password: String) {
        val request = AuthRequest(login, password)
        viewModelScope.launch {
            _userState.value = repository.auth(request)
        }
    }
    //endregion

}