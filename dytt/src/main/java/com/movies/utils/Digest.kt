package com.movies.utils

import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils

/**
 * @author donnieSky
 * @created_at 2018/8/22.
 * @description
 * @version
 */
class Digest {
    fun md5Hex(str: String): String {
        return String(Hex.encodeHex(DigestUtils.md5(str)))
    }
}