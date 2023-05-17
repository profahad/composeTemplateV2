package com.fahad.samples.compose_template_ii.data.auth

import com.fahad.samples.compose_template_ii.models.requests.auth.ForgotPasswordRequest
import com.fahad.samples.compose_template_ii.models.requests.auth.LoginRequest
import com.fahad.samples.compose_template_ii.models.requests.auth.SignUpRequest
import com.fahad.samples.compose_template_ii.network.middlewares.flowResponse
import javax.inject.Inject

/**
 * Auth repository
 *
 * @property authDataSource
 * @constructor Create empty Auth repository
 */
class AuthRepository @Inject constructor(
    private val authDataSource: AuthDataSource
) {

    /**
     * Login
     *
     * @param loginRequest
     */
    fun login(loginRequest: LoginRequest?) = flowResponse { authDataSource.login(loginRequest) }

    /**
     * Sign up
     *
     * @param signUpRequest
     */
    fun signUp(signUpRequest: SignUpRequest?) =
        flowResponse { authDataSource.signUp(signUpRequest) }

    /**
     * Forgot password
     *
     * @param forgotPasswordRequest
     */
    fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest?) =
        flowResponse { authDataSource.forgotPassword(forgotPasswordRequest) }

}