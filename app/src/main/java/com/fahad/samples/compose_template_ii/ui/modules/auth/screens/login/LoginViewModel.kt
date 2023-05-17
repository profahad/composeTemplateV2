package com.fahad.samples.compose_template_ii.ui.modules.auth.screens.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahad.samples.compose_template_ii.data.auth.AuthRepository
import com.fahad.samples.compose_template_ii.models.requests.auth.LoginRequest
import com.fahad.samples.compose_template_ii.models.user.CoreUser
import com.fahad.samples.compose_template_ii.network.enums.Response
import com.fahad.samples.compose_template_ii.network.enums.Status
import com.fahad.samples.compose_template_ii.network.responsebodies.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    val loginRequest = MutableStateFlow(LoginRequest())

    private val _loginResponse =
        MutableStateFlow<Response<ApiResponse<CoreUser>>>(Response(Status.NONE, null, null))
    val loginResponse: StateFlow<Response<ApiResponse<CoreUser>>>
        get() = _loginResponse

    fun login() {
        viewModelScope.launch {
            authRepository.login(loginRequest.value).collect { response ->
                _loginResponse.value = response
            }
        }
    }

    fun setUsername(it: String) {
        loginRequest.value = loginRequest.value.copy(
            username = it
        )
    }

    fun setPassword(it: String) {
        loginRequest.value = loginRequest.value.copy(
            password = it
        )
    }
}