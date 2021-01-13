package com.win.ft_home.ui.home

import androidx.lifecycle.MutableLiveData
import com.win.ft_home.model.home.Banner
import com.win.lib_base.extentions.showToast
import com.win.lib_base.viewModel.BaseViewModel
import com.win.lib_net.model.NetResult

class HomeViewModel(private val homeRepository: HomeRepository) : BaseViewModel() {

    private val bannerLiveData = MutableLiveData<List<Banner>>()

    fun getBannerLiveData(): MutableLiveData<List<Banner>> {
        return bannerLiveData
    }

    fun getBanner() {
        launch {
            val banner = homeRepository.getBanner()
            if (banner is NetResult.Success) {
                bannerLiveData.postValue(banner.data)
            } else if (banner is NetResult.Error) {
                banner.exception.msg?.let { showToast(it) }
            }
        }
    }
}