package com.win.lib_base.utils

import android.content.Context

/**
 * Create by liwen on 2020/6/4
 */
object BaseContext {

    private lateinit var mContext: Context

    fun init(context: Context) {
        mContext = context
    }

    fun getContext(): Context {
        return mContext
    }
}