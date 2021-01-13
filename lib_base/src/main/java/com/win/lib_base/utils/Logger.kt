package com.win.lib_base.utils

import android.util.Log
import com.win.lib_base.extentions.debugEnable

object Logger {

    private const val DEFAULT_TAG = "log"

    fun i(tag: String, msg: String) {
        if (debugEnable())
            Log.i(tag, msg)
    }

    fun v(tag: String, msg: String) {
        if (debugEnable())
            Log.v(tag, msg)
    }

    fun d(tag: String, msg: String) {
        if (debugEnable())
            Log.d(tag, msg)
    }

    fun e(tag: String, msg: String) {
        if (debugEnable())
            Log.e(tag, msg)
    }

    fun i(msg: String) {
        i(DEFAULT_TAG, msg)
    }

    fun v(msg: String) {
        v(DEFAULT_TAG, msg)
    }

    fun d(msg: String) {
        d(DEFAULT_TAG, msg)
    }

    fun e(msg: String) {
        e(DEFAULT_TAG, create(msg))
    }

    private fun create(log: String): String {
        val sb = StringBuffer()
        sb.append("\n").append("--→")
        sb.append(log)
        return log
    }
}
