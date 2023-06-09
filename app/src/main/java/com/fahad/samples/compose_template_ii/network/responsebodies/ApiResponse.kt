package com.fahad.samples.compose_template_ii.network.responsebodies

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("success") var success: Boolean?,
    @SerializedName("message") var message: String?,
    @SerializedName("data") var data: T?
)
