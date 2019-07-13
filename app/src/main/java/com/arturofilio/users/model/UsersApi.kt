package com.arturofilio.users.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersApi {

    @GET("/api/users")
    fun getUsers(): Single<Data>

    @POST("/api/users")
    fun createUser(): Single<User>

}