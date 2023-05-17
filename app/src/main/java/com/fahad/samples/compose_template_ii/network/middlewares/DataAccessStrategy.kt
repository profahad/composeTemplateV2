package com.fahad.samples.compose_template_ii.network.middlewares

import com.fahad.samples.compose_template_ii.network.enums.Response
import com.fahad.samples.compose_template_ii.network.enums.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun <T> flowResponse(
    networkCall: suspend () -> Response<T>,
): Flow<Response<T>> = flow {
    emit(Response.loading())
    val responseStatus = networkCall.invoke()
    when (responseStatus.status) {
        Status.SUCCESS -> {
            emit(Response.success(responseStatus.data!!))
        }
        else -> {
            emit(
                Response.error(
                    data = null, message = responseStatus.message!!, responseStatus.rawData
                )
            )
        }
    }
}.catch {
    emit(Response.error(data = null, message = it.message!!))
}.flowOn(Dispatchers.IO)