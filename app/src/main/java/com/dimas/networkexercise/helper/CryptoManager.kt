package com.dimas.networkexercise.helper

import java.io.InputStream
import java.io.OutputStream

interface CryptoManager {
    fun setupEncryptionKeys()
    fun encrypt(byteArray: ByteArray, outputStream: OutputStream): ByteArray
    fun decrypt(inputStream: InputStream): ByteArray
}