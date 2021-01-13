package com.win.lib_base.service.aboutus.wrap

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.win.lib_base.extentions.ABOUT_US_SERVICE_PATH
import com.win.lib_base.service.aboutus.AboutUsService

/**
 * Create by liwen on 2020/5/27
 */
object AboutUsServiceImplWrap {

    @Autowired(name = ABOUT_US_SERVICE_PATH)
    lateinit var service: AboutUsService

    init {
        ARouter.getInstance().inject(this)
    }

    fun start(context: Context) {
        return service.start(context)
    }
}