package com.fahad.samples.compose_template_ii.network.middlewares

import com.fahad.samples.compose_template_ii.utils.config.CONSTANTS
import com.fahad.samples.compose_template_ii.network.enums.Response
import com.fahad.samples.compose_template_ii.network.exceptions.*
import com.fahad.samples.compose_template_ii.utils.session.SessionManager
import com.google.gson.stream.MalformedJsonException
import retrofit2.HttpException
import timber.log.Timber
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> retrofit2.Response<T>): Response<T> {
        val response: retrofit2.Response<T>
        try {
            response = call()
        } catch (e: MalformedJsonException) {
            if (!CONSTANTS.CONFIG.isProductionMode()) e.printStackTrace()
            return error(InternalServerException().message)
        } catch (t: Throwable) {
            if (!CONSTANTS.CONFIG.isProductionMode()) t.printStackTrace()
            return error(mapToNetworkError(t).message!!)
        }
        if (response.code() == 403 || response.code() == 401) {
            SessionManager.logout()
        }
        when {
            response.isSuccessful -> {
                val body = response.body()
                if (body != null) return Response.success(body)
            }
            else -> {
                val errorBody = response.errorBody()
                val errorResponse = response.errorBody()?.string()
                /*val errorResponse =
                    Gson().fromJson(errorBody?.charStream(), ApiResponse::class.java)*/
                return when {
                    errorResponse != null -> {
                        error(mapApiException(response.code()).message!!, errorResponse)
                    }
                    errorBody != null -> {
                        error(mapApiException(response.code()).message!!, errorResponse)
                    }
                    else -> error(mapApiException(0).message!!, errorResponse)
                }
            }
        }
        return error(HttpException(response).message!!)
    }

    private suspend fun mapApiException(code: Int): Exception {
        return when (code) {
            HttpURLConnection.HTTP_NOT_FOUND -> NotFoundException()
            HttpURLConnection.HTTP_UNAUTHORIZED -> {
                SessionManager.logout()
                UnAuthorizedException()
            }
            HttpURLConnection.HTTP_INTERNAL_ERROR -> InternalServerException()
            else -> UnKnownException()
        }
    }

    private fun mapToNetworkError(t: Throwable): Exception {
        return when (t) {
            is SocketTimeoutException -> SocketTimeoutException("Connection Timed Out")
            is ConnectException -> NoInternetException()
            is UnknownHostException -> Exception("Server not responding")
            else -> UnKnownException()
        }
    }

    private fun <T> error(message: String, rawData: String?): Response<T> {
        if (!CONSTANTS.CONFIG.isProductionMode()) Timber.d(message)
        // CONSTANTS.NETWORK.SOMETHING_WENT_WRONG.format(message)
        return Response.error(message = message, rawData = rawData)
    }

}


fun String.toThrow(): Throwable = Throwable(this)