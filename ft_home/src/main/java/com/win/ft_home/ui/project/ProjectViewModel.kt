package com.win.ft_home.ui.project

import androidx.lifecycle.MutableLiveData
import com.win.ft_home.model.project.ProjectTabItem
import com.win.lib_base.extentions.showToast
import com.win.lib_base.viewModel.BaseViewModel
import com.win.lib_net.model.NetResult

class ProjectViewModel(private val navigationRepo: ProjectRepository) : BaseViewModel() {

    private val tabDataLiveData = MutableLiveData<MutableList<ProjectTabItem>>()

    fun getTabData(): MutableLiveData<MutableList<ProjectTabItem>> {
        launch {
            val tabData = navigationRepo.getTabData()
            if (tabData is NetResult.Success) {
                tabDataLiveData.postValue(tabData.data)
            } else if (tabData is NetResult.Error) {
                tabData.exception.msg?.let { showToast(it) }
            }
        }
        return tabDataLiveData
    }
}