package com.win.ft_search.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.win.ft_search.model.HotKeyModel
import com.win.ft_search.ui.repository.SearchRepository
import com.win.lib_base.extentions.showToast
import com.win.lib_base.viewModel.BaseViewModel
import com.win.lib_net.model.NetResult

/**
 * Create by liwen on 2020/6/1
 */
class HotKeyViewModel(private val repo: SearchRepository) : BaseViewModel() {

    private val hotKeyLiveData = MutableLiveData<MutableList<HotKeyModel>>()

    fun getHotKey(): MutableLiveData<MutableList<HotKeyModel>> {
        launch {
            val hotKey = repo.getHotKey()
            if (hotKey is NetResult.Success) {
                hotKeyLiveData.postValue(hotKey.data)
            } else if (hotKey is NetResult.Error) {
                hotKey.exception.msg?.let { showToast(it) }
            }
        }
        return hotKeyLiveData
    }
}