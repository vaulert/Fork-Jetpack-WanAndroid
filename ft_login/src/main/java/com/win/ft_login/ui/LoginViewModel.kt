package com.win.ft_login.ui

import androidx.lifecycle.MutableLiveData
import com.win.lib_base.extentions.showToast
import com.win.lib_base.model.User
import com.win.lib_base.viewModel.BaseViewModel
import com.win.lib_net.model.NetResult

/**
 * Create by liwen on 2020/5/27
 */
class LoginViewModel(private val loginRepo: LoginRepository) : BaseViewModel() {

    private val loginLiveData = MutableLiveData<User>()

    fun login(username: String, password: String): MutableLiveData<User> {
        launch {
            val user = loginRepo.login(username, password)
            if (user is NetResult.Success) {
                loginLiveData.postValue(user.data)
            } else if (user is NetResult.Error) {
                user.exception.msg?.let { showToast(it) }
            }
        }
        return loginLiveData
    }

    fun register(username: String, password: String, surePassword: String): MutableLiveData<User> {
        launch {
            val user = loginRepo.register(username, password, surePassword)
            if (user is NetResult.Success) {
                loginLiveData.postValue(user.data)
            } else if (user is NetResult.Error) {
                user.exception.msg?.let { showToast(it) }
            }
        }
        return loginLiveData
    }
}