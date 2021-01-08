package com.win.wan_android.startup

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.rousetime.android_startup.AndroidStartup
import com.win.wan_android.BuildConfig.DEBUG

class ARouterInit : AndroidStartup<Unit>() {

    override fun callCreateOnMainThread(): Boolean = true
    override fun waitOnMainThread(): Boolean = true

    override fun create(context: Context) {
        if (DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
            ARouter.printStackTrace()
        }
        ARouter.init(context as Application)
    }
}