package com.czl.module_search.ui.fragment

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.czl.lib_base.base.BaseFragment
import com.czl.lib_base.config.AppConstants
import com.czl.module_search.BR
import com.czl.module_search.R
import com.czl.module_search.databinding.SearchFragmentSearchBinding
import com.czl.module_search.viewmodel.SearchViewModel
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen
import com.gyf.immersionbar.ImmersionBar

/**
 * @author Alwyn
 * @Date 2020/10/19
 * @Description
 */
@Route(path = AppConstants.Router.Search.F_SEARCH)
class SearchFragment : BaseFragment<SearchFragmentSearchBinding, SearchViewModel>() {

    private lateinit var rySkeletonScreen: SkeletonScreen

    override fun initContentView(): Int {
        return R.layout.search_fragment_search
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun isThemeRedStatusBar(): Boolean {
        return true
    }

    override fun useBaseLayout(): Boolean {
        return false
    }

    override fun enableLazy(): Boolean {
        return false
    }

    override fun initData() {
        val keyword = arguments?.getString(AppConstants.BundleKey.MAIN_SEARCH_KEYWORD)
        keyword?.let {
            viewModel.keyword = it
            viewModel.searchPlaceHolder.set(it)
            rySkeletonScreen = Skeleton.bind(binding.smartCommon)
                .load(R.layout.search_item_skeleton)
                .show()
            viewModel.getSearchDataByKeyword(it,-1)
        }
        binding.searchBar.isSuggestionsEnabled = false
    }

    override fun initViewObservable() {
        viewModel.uc.searchCancelEvent.observe(this, Observer {
            binding.searchBar.closeSearch()
        })
        viewModel.uc.finishLoadEvent.observe(this, Observer { data ->
            Handler(Looper.getMainLooper())
                .postDelayed({ rySkeletonScreen.hide() }, 300)
            if (data == null) {
                binding.smartCommon.finishRefresh(false)
                binding.smartCommon.finishLoadMore(false)
                loadService.showWithConvertor(-1)
                return@Observer
            }
            loadService.showWithConvertor(0)
            binding.smartCommon.apply {
                finishRefresh(300)
                if (data.over) finishLoadMoreWithNoMoreData() else finishLoadMore()
            }
        })
        viewModel.uc.moveTopEvent.observe(this, Observer {
            binding.ryCommon.smoothScrollToPosition(0)
        })
    }

    override fun reload() {
        super.reload()
        viewModel.getSearchDataByKeyword(viewModel.keyword, viewModel.currentPage)
    }


}