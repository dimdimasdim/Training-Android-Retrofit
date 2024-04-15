package com.dimas.networkexercise.base

import android.app.Application
import android.content.Context
import androidx.datastore.dataStore
import com.dimas.networkexercise.helper.CryptoManagerImpl
import com.dimas.networkexercise.utils.ApplicationProviderUtils
import com.dimas.networkexercise.utils.DataStoreUtils
import com.dimas.networkexercise.utils.UserSettingsSerializer

class BaseApplication: Application() {

    private val Context.dataStore by dataStore(
        fileName = "user-settings.json",
        serializer = UserSettingsSerializer()
    )

    override fun onCreate() {
        super.onCreate()
        ApplicationProviderUtils.initialize(this)
        DataStoreUtils.initialize(dataStore)
    }
}