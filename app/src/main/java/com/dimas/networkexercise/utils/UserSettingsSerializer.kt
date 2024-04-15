package com.dimas.networkexercise.utils

import com.dimas.networkexercise.domain.model.User
import kotlinx.serialization.SerializationException
import androidx.datastore.core.Serializer
import com.dimas.networkexercise.helper.CryptoManagerImpl
import java.io.InputStream
import java.io.OutputStream
import kotlinx.serialization.json.Json


class UserSettingsSerializer() : Serializer<User> {
    override val defaultValue: User get() = User()

    override suspend fun readFrom(input: InputStream): User {
        // TODO:
        return User()
    }

    override suspend fun writeTo(t: User, output: OutputStream) {
        // TODO:
    }
}