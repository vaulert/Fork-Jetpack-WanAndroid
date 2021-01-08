package com.win.wan_android.startup

import android.content.Context
import com.rousetime.android_startup.AndroidStartup
import com.tencent.mmkv.MMKV

class MmkvInit : AndroidStartup<Unit>() {

    override fun callCreateOnMainThread(): Boolean = true
    override fun waitOnMainThread(): Boolean = true

    override fun create(context: Context) {
        MMKV.initialize(context)
    }
}