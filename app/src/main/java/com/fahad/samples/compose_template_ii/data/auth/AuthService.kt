package com.fahad.samples.compose_template_ii.data.auth

import com.fahad.samples.compose_template_ii.models.requests.auth.ForgotPasswordRequest
import com.fahad.samples.compose_template_ii.models.requests.auth.LoginRequest
import com.fahad.samples.compose_template_ii.models.requests.auth.SignUpRequest
import com.fahad.samples.compose_template_ii.models.user.CoreUser
import com.fahad.samples.compose_template_ii.network.responsebodies.ApiResponse
import com.fahad.samples.compose_template_ii.utils.config.CONSTANTS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * Auth service
 *
 * @constructor Create empty Auth service
 */
interface AuthService {

    /**
     * Login
     *
     * @param loginRequest
     * @return
     */
    @POST(CONSTANTS.APIS.LOGIN)
    suspend fun login(@Body loginRequest: LoginRequest?): Response<ApiResponse<CoreUser>>

    /**
     * Sign up
     *
     * @param signUpRequest
     * @return
     */
    @POST(CONSTANTS.APIS.SIGN_UP)
    suspend fun signUp(@Body signUpRequest: SignUpRequest?): Response<Any>

    /**
     * Forgot password
     *
     * @param forgotPasswordRequest
     * @return
     */
    @POST(CONSTANTS.APIS.FORGOT_PASSWORD)
    suspend fun forgotPassword(@Body forgotPasswordRequest: ForgotPasswordRequest?): Response<Any>

}