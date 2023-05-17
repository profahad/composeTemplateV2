package com.fahad.samples.compose_template_ii.data.auth

import com.fahad.samples.compose_template_ii.models.requests.auth.ForgotPasswordRequest
import com.fahad.samples.compose_template_ii.models.requests.auth.LoginRequest
import com.fahad.samples.compose_template_ii.models.requests.auth.SignUpRequest
import com.fahad.samples.compose_template_ii.network.middlewares.BaseDataSource
import javax.inject.Inject

/**
 * Auth data source
 *
 * @property authService
 * @constructor Create empty Auth data source
 */
class AuthDataSource @Inject constructor(private val authService: AuthService) : BaseDataSource() {


    /**
     * Login
     *
     * @param loginRequest
     */
    suspend fun login(loginRequest: LoginRequest?) = getResult { authService.login(loginRequest) }

    /**
     * Sign up
     *
     * @param signUpRequest
     */
    suspend fun signUp(signUpRequest: SignUpRequest?) =
        getResult { authService.signUp(signUpRequest) }

    /**
     * Forgot password
     *
     * @param forgotPasswordRequest
     */
    suspend fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest?) =
        getResult { authService.forgotPassword(forgotPasswordRequest) }
}