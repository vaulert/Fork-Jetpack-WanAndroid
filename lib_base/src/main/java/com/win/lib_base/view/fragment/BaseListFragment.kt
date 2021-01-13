//package com.win.lib_base.view.fragment
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.core.content.ContextCompat
//import androidx.databinding.DataBindingUtil
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.Observer
//import androidx.paging.PagingDataAdapter
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.scwang.smartrefresh.layout.SmartRefreshLayout
//import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
//import com.scwang.smartrefresh.layout.listener.OnRefreshListener
//import com.win.lib_base.R
//import com.win.lib_base.databinding.AbsListLayoutBinding
//import com.win.lib_base.viewModel.BasePagingViewModel
//import org.koin.androidx.viewmodel.ext.android.getViewModel
//import kotlin.reflect.KClass
//
///**
// * @see AbsListFragment
// */
//abstract class BaseListFragment<T : Any, VM : BasePagingViewModel<T>, VH : RecyclerView.ViewHolder> :
//    Fragment(), OnRefreshListener, OnLoadMoreListener {
//
//    private val mAdapter: PagingDataAdapter<T, VH> by lazy { getAdapter() }
//    lateinit var mViewModel: VM
//    private lateinit var mRefreshLayout: SmartRefreshLayout
//    private lateinit var mRecycleView: RecyclerView
//    private lateinit var mBinding: AbsListLayoutBinding
//
//    abstract fun getAdapter(): PagingDataAdapter<T, VH>
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        mBinding = DataBindingUtil.inflate(
//            inflater,
//            R.layout.abs_list_layout,
//            container, false
//        )
//        mRefreshLayout = mBinding.refreshLayout
//        mRecycleView = mBinding.recycleView
//        mRecycleView.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//        val decoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
//        decoration.setDrawable(
//            ContextCompat.getDrawable(
//                requireContext(),
//                R.drawable.home_list_divier
//            )!!
//        )
//        mRecycleView.addItemDecoration(decoration)
//
//        mRecycleView.adapter = mAdapter
//
//        mRefreshLayout.setEnableRefresh(true)
//        mRefreshLayout.setEnableLoadMore(true)
//
//        mRefreshLayout.setOnRefreshListener(this)
//        mRefreshLayout.setOnLoadMoreListener(this)
//
//        initViewModel()
//
//        onCreateViewAfter()
//
//        return mBinding.root
//    }
//
//    private fun initViewModel() {
//        val clazz =
//            this.javaClass.kotlin.supertypes[0].arguments[1].type!!.classifier!! as KClass<VM>
//        mViewModel = getViewModel(clazz)
//
//        mViewModel.pageList.observe(viewLifecycleOwner, Observer {
//            mAdapter.submitData(lifecycle, it)
//        })
//    }
//
//    open fun onCreateViewAfter() {}
//}