//package com.win.lib_base.viewModel
//
//import androidx.lifecycle.asLiveData
//import androidx.lifecycle.viewModelScope
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import androidx.paging.PagingSource
//import androidx.paging.cachedIn
//
///**
// * @see AbsListViewModel
// */
//abstract class BasePagingViewModel<T : Any> : BaseViewModel() {
//
//    abstract suspend fun getDataList(page: Int): List<T>
//
//    val pageList by lazy {
//        Pager(config = PagingConfig(pageSize = 20, prefetchDistance = 1)) {
//            PageDataSource()
//        }.flow.asLiveData().cachedIn(viewModelScope)
//    }
//
//    inner class PageDataSource : PagingSource<Int, T>() {
//        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
//            return try {
//                val page = params.key ?: 1
//                val list = getDataList(page)
//                LoadResult.Page(
//                    data = getDataList(page),
//                    prevKey = null,
//                    nextKey = if (list.isEmpty()) null else page + 1
//                )
//            } catch (e: Exception) {
//                LoadResult.Error(e)
//            }
//        }
//    }
//}