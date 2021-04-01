package com.location.wanandroid.view.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.location.base.BaseFragment
import com.location.base.fixInputMethodManagerLeak
import com.location.base.logDebug
import com.location.base.startNewActivity
import com.location.wanandroid.*
import com.location.wanandroid.adapter.home.HomeAdapter
import com.location.wanandroid.adapter.home.ItemClickListener
import com.location.wanandroid.data.HomeListData
import com.location.wanandroid.databinding.FragmentHomeBinding
import com.location.wanandroid.padingsource.HomeSourceType
import com.location.wanandroid.view.DetailsActivity.Companion.KEY_URL
import com.location.wanandroid.viewmodels.home.HomeViewModel
import com.location.base.widget.FavoritesView
import com.location.wanandroid.view.DetailsActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 10:51 PM
 * description：
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(),
    ItemClickListener {
    companion object {
        private const val EXERA_TYPE = "data_type"
        private const val TAG = "HomeFragment"
        fun buildBundle(type: HomeSourceType): Bundle {
            return bundleOf(EXERA_TYPE to type.ordinal)
        }
    }


    override val layoutId: Int
        get() = R.layout.fragment_home

    private val adapter by lazy {
        HomeAdapter(
            this@HomeFragment
        )
    }
    private val homeModel: HomeViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.adapter = adapter
        binding.lifecycleOwner = this

        lifecycleScope.launch {
            /**
             * 获取flow数据
             */
            when (arguments?.getInt(EXERA_TYPE) ?: HomeSourceType.HOME_DATA.ordinal) {
                HomeSourceType.HOME_DATA.ordinal -> homeModel.homeFlow
                HomeSourceType.QA_DATA.ordinal -> homeModel.qaFlow
                else -> homeModel.homeFlow
            }.collectLatest {
                adapter.submitData(it)
            }
        }

        UserManager.userState.observe(viewLifecycleOwner, Observer {
            if(it == UserState.LOGOUT || it == UserState.LOGIN){
                //登陆状态改变后 刷新数据
                adapter.refresh()
            }
        })
    }

    override fun onItemClick(data: HomeListData, position: Int) {

        startNewActivity<DetailsActivity>{
            putExtras(bundleOf(KEY_URL to data.link))
        }
    }

    override fun onCollect(
        data: HomeListData,
        position: Int,
        collect: Boolean,
        view: FavoritesView
    ) {
        lifecycleScope.launch {
            if (!UserManager.isLogin()) {
                startNewActivity<MainActivity>()
                return@launch
            }
            val status = homeModel.collect(data.id, !collect)
            logDebug(TAG, "collect_result$status")
            if (status) {
                view.toggle()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fixInputMethodManagerLeak(appContext)
    }

}