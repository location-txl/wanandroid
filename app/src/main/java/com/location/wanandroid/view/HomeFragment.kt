package com.location.wanandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.location.base.BaseFragment
import com.location.base.fixInputMethodManagerLeak
import com.location.base.logDebug
import com.location.base.startNewActivity
import com.location.wanandroid.MainActivity
import com.location.wanandroid.R
import com.location.wanandroid.UserManager
import com.location.wanandroid.adapter.HomeAdapter
import com.location.wanandroid.adapter.ItemClickListener
import com.location.wanandroid.appContext
import com.location.wanandroid.data.HomeListData
import com.location.wanandroid.databinding.FragmentHomeBinding
import com.location.wanandroid.padingsource.HomeSourceType
import com.location.wanandroid.view.DetailsActivity.Companion.KEY_URL
import com.location.wanandroid.viewmodel.HomeViewModel
import com.location.wanandroid.widget.FavoritesView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 10:51 PM
 * description：
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(), ItemClickListener {
    companion object{
        private const val  EXERA_TYPE = "data_type"
        fun buildBundle(type:HomeSourceType):Bundle{
            return bundleOf(EXERA_TYPE to type.ordinal)
        }
    }
    private val TAG = "HomeFragment"
    override val layoutId: Int
        get() = R.layout.fragment_home

    private val adapter by lazy { HomeAdapter(this@HomeFragment) }
    private val homeModel:HomeViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.adapter = adapter
        binding.lifecycleOwner = this
        lifecycleScope.launch {
            when(arguments?.getInt(EXERA_TYPE) ?: HomeSourceType.HOME_DATA.ordinal){
                HomeSourceType.HOME_DATA.ordinal -> {homeModel.homeFlow.collectLatest {
                    adapter.submitData(it)
                }}
                HomeSourceType.QA_DATA.ordinal -> {
                    homeModel.qaFlow.collectLatest {
                        adapter.submitData(it)
                    }
                }
            }
        }
    }

    override fun onItemClick(data: HomeListData, position: Int) {
        val bundle = bundleOf(KEY_URL to data.link)
        startNewActivity<DetailsActivity>(bundle)
    }

    override fun onCollect(data: HomeListData, position: Int,checked:Boolean,view:FavoritesView) {
          lifecycleScope.launch {
              if(!UserManager.isLogin()){
                  startNewActivity<MainActivity>()
                  return@launch
              }
              val collect = homeModel.collect(data.id,!checked)
              logDebug(TAG,"collect_result$collect")
              if(collect){
                  view.toggle()
              }
          }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fixInputMethodManagerLeak(appContext)
    }

}