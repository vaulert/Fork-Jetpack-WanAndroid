package com.win.ft_home.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.win.ft_home.R
import com.win.ft_home.databinding.ActivityMainNewBinding
import com.win.lib_base.base.BaseActivity
import com.win.lib_base.extentions.*
import me.majiajie.pagerbottomtabstrip.NavigationController
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem
import me.majiajie.pagerbottomtabstrip.item.NormalItemView
import java.util.*

class NewMainActivity : BaseActivity<MainViewModel, ActivityMainNewBinding>() {

    private var pressTime: Long = 0
    private var defaultPage = 0
    private var defaultTime = 2000
    private val mStack: Stack<Fragment> by lazy { Stack<Fragment>() }
    private val homeFragment: Fragment by lazy { toFragment(PATH_HOME_FRAGMENT) }
    private val projectFragment: Fragment by lazy { toFragment(PATH_PROJECT_FRAGMENT) }
    private val navFragment: Fragment by lazy { toFragment(PATH_NAV_FRAGMENT) }
    private val treeFragment: Fragment by lazy { toFragment(PATH_TREE_FRAGMENT) }
    private val mineFragment: Fragment by lazy { toFragment(PATH_MINE_FRAGMENT) }
    private lateinit var controller: NavigationController

    override fun getLayoutResId(): Int = R.layout.activity_main_new

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        mViewBinding.content
    }

    override fun initData() {

    }

    override fun initView() {
        initFragment()
    }

    private fun initFragment() {
        mStack.add(homeFragment)
        mStack.add(projectFragment)
        mStack.add(navFragment)
        mStack.add(treeFragment)
        mStack.add(mineFragment)

        controller = mViewBinding.tab.custom()
            .addItem(
                newItem(
                    R.drawable.ic_home_normal,
                    R.drawable.ic_home_press,
                    "首页"
                )
            )
            .addItem(
                newItem(
                    R.drawable.ic_notice_normal,
                    R.drawable.ic_notice_press,
                    "项目"
                )
            )
            .addItem(
                newItem(
                    R.drawable.ic_map_normal,
                    R.drawable.ic_map_press,
                    "导航"
                )
            )
            .addItem(
                newItem(
                    R.drawable.ic_system_normal,
                    R.drawable.ic_system_press,
                    "体系"
                )
            )
            .addItem(
                newItem(
                    R.drawable.ic_mine_normal,
                    R.drawable.ic_mine_press,
                    "我的"
                )
            )
            .build()
        mViewBinding.content.adapter = MainAdapter(supportFragmentManager, mStack)
        mViewBinding.content.offscreenPageLimit = mStack.size - 1
        controller.setupWithViewPager(mViewBinding.content)
    }

    private fun newItem(drawable: Int, checkDrawable: Int, title: String): BaseTabItem {
        val item = NormalItemView(this)
        item.initialize(drawable, checkDrawable, title)
        item.setTextCheckedColor(ContextCompat.getColor(this, android.R.color.black))
        item.setTextDefaultColor(ContextCompat.getColor(this, android.R.color.darker_gray))
        return item
    }

    override fun onBackPressed() {
        if (mViewBinding.content.currentItem != defaultPage) {
            mViewBinding.content.currentItem = defaultPage
        } else {
            val time = System.currentTimeMillis()
            if (time - pressTime > defaultTime) {
                Toast.makeText(this, "离开咯!", Toast.LENGTH_SHORT).show()
                pressTime = time
            } else {
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack()
                } else {
                    super.onBackPressed()
                }
            }
        }
    }
}