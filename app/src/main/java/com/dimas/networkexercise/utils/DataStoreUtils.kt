package com.dimas.networkexercise.utils

import androidx.datastore.core.DataStore
import com.dimas.networkexercise.domain.model.User

object DataStoreUtils {
    private var dataStore: DataStore<User>? = null


    private fun init(dataStore: DataStore<User>) {
        this.dataStore = dataStore
    }

    private fun getDataStore(): DataStore<User> {
        if (dataStore == null) {
            throw IllegalStateException("call init first")
        }
        return dataStore!!
    }


    @JvmStatic
    fun initialize(dataStore: DataStore<User>) {
        init(dataStore)
    }

    @JvmStatic
    fun get(): DataStore<User> {
        return getDataStore()
    }
}