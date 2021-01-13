package com.win.ft_home.ui.tree

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.win.ft_home.model.tree.TreeData
import com.win.lib_base.utils.BaseContext
import com.win.lib_base.viewModel.BaseViewModel
import com.win.lib_net.model.NetResult

class TreeViewModel(private val treeRepository: TreeRepository) : BaseViewModel() {

    private val treeDataLiveData = MutableLiveData<MutableList<TreeData>>()

    fun getTreeDataLiveData(): MutableLiveData<MutableList<TreeData>> {
        return treeDataLiveData
    }

    fun getTreeList() {
        launch {
            val treeData = treeRepository.getTreeList()
            if (treeData is NetResult.Success) {
                treeDataLiveData.postValue(treeData.data)
            } else if (treeData is NetResult.Error) {
                Toast.makeText(
                    BaseContext.getContext(),
                    treeData.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}