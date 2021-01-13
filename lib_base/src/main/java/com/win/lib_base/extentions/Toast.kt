package com.win.lib_base.extentions

import android.widget.Toast
import androidx.annotation.StringRes
import com.win.lib_base.R
import com.win.lib_base.utils.BaseContext

fun CharSequence.shortToast() {
    Toast.makeText(BaseContext.getContext(), this, Toast.LENGTH_SHORT).show()
}

@StringRes
fun Int.shortToast(): Int {
    Toast.makeText(BaseContext.getContext(), this, Toast.LENGTH_SHORT).show()
    return R.string.app_name
}

fun shortToast(@StringRes resId: Int) {
    Toast.makeText(BaseContext.getContext(), resId, Toast.LENGTH_SHORT).show()
}

fun showToast(string: String) {
    Toast.makeText(BaseContext.getContext(), string, Toast.LENGTH_SHORT).show()
}