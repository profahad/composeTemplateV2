package com.fahad.samples.compose_template_ii.models.requests.auth

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var password: String? = null,
)