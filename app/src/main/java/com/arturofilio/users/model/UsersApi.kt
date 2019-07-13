package com.arturofilio.users.model

import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersApi {

    @GET("/api/users")
    fun getUsers(): Single<Data>

    // This request will send two values as required in the api doc,
    @FormUrlEncoded
    @POST("/api/users")
    fun createUser(
        @Field("name") name: String,
        @Field("job") job: String
    ): Single<User>

}