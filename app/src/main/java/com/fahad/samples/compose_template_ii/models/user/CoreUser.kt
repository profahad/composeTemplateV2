package com.fahad.samples.compose_template_ii.models.user

import com.google.gson.annotations.SerializedName

data class CoreUser(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("access") var accessToken: String? = null,
) {
    val fullName: String
        get() = "$firstName $lastName"
}