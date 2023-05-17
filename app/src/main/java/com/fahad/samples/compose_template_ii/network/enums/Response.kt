package com.fahad.samples.compose_template_ii.network.enums

data class Response<out T>(
    val status: Status, val data: T?, val message: String?, val rawData: String? = null
) {
    companion object {
        fun <T> success(data: T): Response<T> =
            Response(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T? = null, message: String, rawData: String? = null): Response<T> =
            Response(status = Status.ERROR, data = data, message = message, rawData = rawData)

        fun <T> loading(): Response<T> =
            Response(status = Status.LOADING, data = null, message = null)

        fun <T> none(): Response<T> =
            Response(status = Status.NONE, data = null, message = null)
    }
}