package com.arturofilio.users.model

import io.reactivex.Single
import retrofit2.http.GET

interface UsersApi {

    @GET("/api/users")
    fun getUsers(): Single<Data>

}