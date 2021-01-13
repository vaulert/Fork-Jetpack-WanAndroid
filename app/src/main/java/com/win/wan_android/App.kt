package com.win.wan_android

import android.app.Application
import com.win.lib_base.utils.BaseContext

/**
 * Create by liwen on 2020-05-18
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initContext()
    }

    private fun initContext() {
        BaseContext.init(this)
    }
}