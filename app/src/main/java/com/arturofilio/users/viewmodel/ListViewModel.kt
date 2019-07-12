package com.arturofilio.users.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.arturofilio.users.model.Data
import com.arturofilio.users.model.User
import com.arturofilio.users.model.UsersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel: ViewModel() {

    private val usersService = UsersService()
    private val disposable = CompositeDisposable()

    val users = MutableLiveData<List<User>>()
    val userLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchUsers()
    }

    private fun fetchUsers() {
        loading.value = true
        disposable.add(
            usersService.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<Data>() {
                    override fun onSuccess(list: Data?) {
                        val i = 0
                        users.value = list?.data
                    }

                    override fun onError(e: Throwable?) {
                        userLoadError.value = true
                        loading.value = false
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}