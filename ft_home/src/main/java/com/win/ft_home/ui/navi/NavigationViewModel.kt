package com.win.ft_home.ui.navi

import androidx.lifecycle.MutableLiveData
import com.win.ft_home.model.navigation.NavigationItem
import com.win.lib_base.extentions.showToast
import com.win.lib_base.viewModel.BaseViewModel
import com.win.lib_net.model.NetResult

class NavigationViewModel(private val navigationRepo: NavigationRepository) : BaseViewModel() {

    private val navigationLiveData = MutableLiveData<MutableList<NavigationItem>>()

    fun getNavigationData(): MutableLiveData<MutableList<NavigationItem>> {
        launch {
            val data = navigationRepo.getNavigationData()
            if (data is NetResult.Success) {
                navigationLiveData.postValue(data.data)
            } else if (data is NetResult.Error) {
                data.exception.msg?.let { showToast(it) }
            }
        }
        return navigationLiveData
    }
}