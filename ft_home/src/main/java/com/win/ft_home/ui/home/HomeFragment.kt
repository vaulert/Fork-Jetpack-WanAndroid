package com.win.ft_home.ui.home

import com.alibaba.android.arouter.facade.annotation.Route
import com.win.ft_home.R
import com.win.ft_home.adapter.HomeBannerAdapter
import com.win.ft_home.databinding.FragmentHomeBinding
import com.win.lib_base.extentions.PATH_HOME_FRAGMENT
import com.win.lib_base.view.fragment.BaseFragment

@Route(path = PATH_HOME_FRAGMENT)
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override fun getLayoutResId(): Int = R.layout.fragment_home

    override fun initView() {
        val supportFragmentManager = activity?.supportFragmentManager
        val beginTransaction = supportFragmentManager?.beginTransaction()
        beginTransaction?.replace(R.id.homeListContainer, HomeListFragment::class.java, null)
        beginTransaction?.commit()
    }

    override fun initData() {
        mViewModel.apply { getBanner() }
        mViewModel.getBannerLiveData().observe(viewLifecycleOwner, {
            mViewBinding.banner.adapter = HomeBannerAdapter(it)
        })
    }
}