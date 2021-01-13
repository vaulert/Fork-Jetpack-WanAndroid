package com.win.ft_about_us.ui

import android.content.Context
import android.content.Intent
import com.win.ft_about_us.R
import com.win.ft_about_us.databinding.ActivityAboutUsBinding
import com.win.lib_base.view.activity.BaseActivity
import com.win.lib_base.viewModel.EmptyViewModel

/**
 * Create by liwen on 2020/7/6
 */
class AboutUsActivity : BaseActivity<EmptyViewModel, ActivityAboutUsBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_about_us

    override fun initView() {
        mViewBinding.mIvBack.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, AboutUsActivity::class.java))
        }
    }

    override fun initData() = Unit
}