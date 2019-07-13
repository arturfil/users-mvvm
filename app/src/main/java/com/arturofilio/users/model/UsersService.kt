package com.arturofilio.users.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UsersService {

    private val BASE_URL = "https://reqres.in"
    private val api: UsersApi

    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(UsersApi::class.java)
    }

    fun getUsers(): Single<Data> {
        return api.getUsers()
    }

    fun createUser(): Single<User> {
        return api.createUser()
    }

}