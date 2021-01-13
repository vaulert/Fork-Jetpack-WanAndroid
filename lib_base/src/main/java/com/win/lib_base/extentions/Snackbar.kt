package com.win.lib_base.extentions

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

fun showSnackbar(view: View, text: CharSequence) {
    Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
        .setAnchorView(view)
        .show()
}

fun showSnackbar(view: View, @StringRes resId: Int) {
    Snackbar.make(view, resId, Snackbar.LENGTH_SHORT).show()
}