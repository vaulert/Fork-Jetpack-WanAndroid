package com.win.lib_base.di

import com.win.lib_base.viewModel.BaseViewModel
import com.win.lib_base.viewModel.EmptyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val lib_base_ViewModel = module {
    viewModel { BaseViewModel() }
    viewModel { EmptyViewModel() }
}