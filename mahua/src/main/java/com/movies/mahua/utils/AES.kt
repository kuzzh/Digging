package com.movies.mahua.utils

import com.movies.mahua.Mahua
import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils.md5
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


/**
 * @author donnieSky
 * @created_at 2018/9/12.
 * @description
 * @version
 */
object AES {

    fun encryptToHex(content: String, forToken: Boolean): String {
        return try {
            String(Hex.encodeHex(aesEncryptToBytes(content, getKey(forToken))))
        } catch (e: Exception) {
            "null"
        }
    }

    fun randomAccessToken(): String {
        val str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val sb = StringBuilder("17")
        for (i in 0 until 14) {
            sb.append(str[Math.floor(Math.random() * str.length).toInt()])
        }
        return encryptToHex(sb.toString(), true)
    }

    private fun getKey(forToken: Boolean): String {
        val key = Mahua.MAHUA_KEY
        if (forToken) {
            return key
        }
        var packageId = "7"
        var sb = StringBuilder()
        sb.append(packageId)
        sb.append(key)
        sb.append(packageId)
        packageId = String(Hex.encodeHex(md5(sb.toString())))
        sb = StringBuilder()
        sb.append(packageId.substring(0, 8))
        sb.append(key.substring(0, 8))
        return sb.toString()
    }

    @Throws(Exception::class)
    private fun aesEncryptToBytes(content: String, key: String): ByteArray {
        val instance = Cipher.getInstance("AES/CBC/PKCS7Padding")
        val bytes = key.toByteArray()
        instance.init(1, SecretKeySpec(bytes, "AES"), IvParameterSpec(bytes))
        return instance.doFinal(content.toByteArray())
    }

}