package com.fahad.samples.compose_template_ii.models.requests.auth

import com.google.gson.annotations.SerializedName

data class ForgotPasswordRequest(
    @SerializedName("email") var email: String? = null,
)