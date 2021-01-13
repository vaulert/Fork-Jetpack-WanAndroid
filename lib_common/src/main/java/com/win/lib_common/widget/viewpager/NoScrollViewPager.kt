package com.win.lib_common.widget.viewpager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent

class NoScrollViewPager(context: Context, attrs: AttributeSet?) :
    androidx.viewpager.widget.ViewPager(context, attrs) {

    private var noScroll: Boolean = true

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return if (noScroll) {
            false
        } else {
            super.onTouchEvent(ev)
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return if (noScroll) {
            false
        } else {
            super.onInterceptTouchEvent(ev)
        }
    }

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item, false)
    }

    fun setScroll(scroll: Boolean) {
        this.noScroll = scroll
    }
}