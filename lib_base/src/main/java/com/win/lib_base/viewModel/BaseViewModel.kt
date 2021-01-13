package com.win.lib_base.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.win.lib_base.utils.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { tryCatch(block) }
    }

    private suspend fun tryCatch(tryBlock: suspend CoroutineScope.() -> Unit) {
        coroutineScope {
            kotlin.runCatching {
                tryBlock()
            }.onFailure {
                Logger.d(it.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}