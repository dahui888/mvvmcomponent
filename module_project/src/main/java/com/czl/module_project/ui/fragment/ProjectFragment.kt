package com.czl.module_project.ui.fragment

import android.annotation.SuppressLint
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.NetworkUtils
import com.czl.lib_base.adapter.ViewPagerFmAdapter
import com.czl.lib_base.base.BaseBean
import com.czl.lib_base.base.BaseFragment
import com.czl.lib_base.callback.ErrorCallback
import com.czl.lib_base.config.AppConstants
import com.czl.lib_base.data.bean.ProjectSortBean
import com.czl.lib_base.extension.ApiSubscriberHelper
import com.czl.lib_base.util.RxThreadHelper
import com.czl.module_project.BR
import com.czl.module_project.R
import com.czl.module_project.databinding.ProjectFragmentProjectBinding
import com.czl.module_project.viewmodel.ProjectViewModel
import com.google.android.material.tabs.TabLayoutMediator
import com.gyf.immersionbar.ImmersionBar


@Route(path = AppConstants.Router.Project.F_PROJECT)
class ProjectFragment : BaseFragment<ProjectFragmentProjectBinding, ProjectViewModel>() {

    override fun initContentView(): Int {
        return R.layout.project_fragment_project
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun useBaseLayout(): Boolean {
        return false
    }



    @SuppressLint("MissingPermission")
    override fun initData() {
        initTab()
    }

    override fun reload() {
        super.reload()
        initTab()
    }

    private fun initTab() {
        val fragments = arrayListOf<ContentFragment>()
        val tabTitles = arrayListOf<String>()
        viewModel.model.getProjectSort()
            .compose(RxThreadHelper.rxSchedulerHelper(viewModel))
            .subscribe(object : ApiSubscriberHelper<BaseBean<List<ProjectSortBean>>>(loadService) {
                override fun onResult(t: BaseBean<List<ProjectSortBean>>) {
                    if (t.errorCode == 0) {
                        for (data in t.data!!) {
                            binding.tabLayout.addTab(binding.tabLayout.newTab())
                            tabTitles.add(data.name)
                            fragments.add(ContentFragment.getInstance(data.id.toString()))
                        }
                        binding.viewpager.apply {
                            adapter = ViewPagerFmAdapter(childFragmentManager, lifecycle, fragments)
                            // 设置该属性后第一次将自动加载所有fragment 不配置该属性则使用viewpager2内部加载机制
                            offscreenPageLimit = fragments.size
                        }
                        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
                            tab.text = tabTitles[position]
                        }.attach()
                    }
                }

                override fun onFailed(msg: String?) {

                    showErrorToast(msg)
                }
            })
    }

}