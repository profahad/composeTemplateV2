package com.fahad.samples.compose_template_ii.ui.modules.auth.screens.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahad.samples.compose_template_ii.data.auth.AuthRepository
import com.fahad.samples.compose_template_ii.models.requests.auth.SignUpRequest
import com.fahad.samples.compose_template_ii.network.enums.Response
import com.fahad.samples.compose_template_ii.network.enums.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    val signUpRequest = MutableStateFlow(SignUpRequest())

    private val _signUpResponse =
        MutableStateFlow<Response<Any>>(Response(Status.NONE, null, null))
    val signUpResponse: StateFlow<Response<Any>>
        get() = _signUpResponse

    fun login() {
        viewModelScope.launch {
            authRepository.signUp(signUpRequest.value).collect { response ->
                _signUpResponse.value = response
            }
        }
    }

    fun setFirstName(it: String) {
        signUpRequest.value = signUpRequest.value.copy(
            firstName = it
        )
    }

    fun setLastName(it: String) {
        signUpRequest.value = signUpRequest.value.copy(
            lastName = it
        )
    }

    fun setEmail(it: String) {
        signUpRequest.value = signUpRequest.value.copy(
            email = it
        )
    }

    fun setPassword(it: String) {
        signUpRequest.value = signUpRequest.value.copy(
            password = it
        )
    }
}