package com.fahad.samples.compose_template_ii.models.requests.auth

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("password") var password: String? = null,
)