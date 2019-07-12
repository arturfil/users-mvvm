package com.arturofilio.users.model

import com.google.gson.annotations.SerializedName

data class Data(
    val data: List<User>?
)

data class User(
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("avatar")
    val userImage: String
)