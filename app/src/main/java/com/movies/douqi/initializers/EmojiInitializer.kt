package com.movies.douqi.initializers

import android.app.Application
import androidx.core.provider.FontRequest
import androidx.emoji.text.EmojiCompat
import androidx.emoji.text.FontRequestEmojiCompatConfig
import com.movies.douqi.R
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
class EmojiInitializer @Inject constructor() : Initializer {
    override fun init(application: Application) {
        val fontRequest = FontRequest(
                "com.google.android.gms.fonts",
                "com.google.android.gms",
                "Noto Color Emoji Compat",
                R.array.com_google_android_gms_fonts_certs)

        val config = FontRequestEmojiCompatConfig(application, fontRequest).setReplaceAll(true)

        EmojiCompat.init(config)
    }
}