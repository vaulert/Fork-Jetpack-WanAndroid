package com.win.lib_base.extentions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.launcher.ARouter

fun toActivity(path: String, activity: FragmentActivity?) {
    ARouter.getInstance().build(path).navigation(activity)
}

fun toFragment(path: String): Fragment {
    return ARouter.getInstance().build(path).navigation() as Fragment
}

const val PATH_HOME_FRAGMENT = "/home/HomeFragment"
const val PATH_PROJECT_FRAGMENT = "/project/ProjectFragment"
const val PATH_NAV_FRAGMENT = "/nav/NavigationFragment"
const val PATH_TREE_FRAGMENT = "/tree/TreeFragment"
const val PATH_MINE_FRAGMENT = "/mine/MineFragment"

/** 体系详情 **/
const val TREE_DETAIL_SERVICE_PATH = "/treeDetail/treeDetail_service"

/** webview **/
const val WEB_VIEW_SERVICE_PATH = "/webView/webView_service"

/** 登录页面 **/
const val LOGIN_SERVICE_PATH = "/login/login_service"

/** 搜索 **/
const val SEARCH_SERVICE_PATH = "/search/search_service"

/** 关于我们 **/
const val ABOUT_US_SERVICE_PATH = "/aboutUs/aboutUs_service"