package com.alirezaafkar.phuzei.presentation.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alirezaafkar.phuzei.App
import com.alirezaafkar.phuzei.data.pref.AppPreferences
import com.alirezaafkar.phuzei.presentation.main.MainActivity
import com.alirezaafkar.phuzei.presentation.login.LoginActivity
import javax.inject.Inject

/**
 * Created by Alireza Afkar on 16/9/2018AD.
 */
class SplashActivity : AppCompatActivity() {
    @Inject lateinit var prefs: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.get(this).component?.inject(this)

        if (prefs.accessToken.isNullOrEmpty()) {
            LoginActivity.start(this)
        } else {
            MainActivity.start(this)
        }
        finish()
    }
}
