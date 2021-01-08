package com.win.wan_android.startup

import android.content.Context
import com.rousetime.android_startup.AndroidStartup
import com.win.wan_android.di.allModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinInit : AndroidStartup<Unit>() {

    override fun callCreateOnMainThread(): Boolean = true
    override fun waitOnMainThread(): Boolean = true

    override fun create(context: Context) {
        startKoin {
            androidContext(context)
            modules(allModule)
        }
    }
}