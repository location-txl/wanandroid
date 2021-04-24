package com.location.wanandroid.view.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.location.base.BaseDaggerVmFragment
import com.location.base.TAG
import com.location.base.logDebug
import com.location.base.recyclerview.BaseClickHolder
import com.location.base.startNewActivity
import com.location.wanandroid.R
import com.location.wanandroid.adapter.home.PubListAdapter
import com.location.wanandroid.data.PublicList
import com.location.wanandroid.databinding.FragmentHomeBinding
import com.location.wanandroid.view.DetailsActivity
import com.location.wanandroid.viewmodels.home.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

/**
 *
 * @author tianxiaolong
 * time：4/20/21 10:46 PM
 * description：
 */
class PublicChildFragment: BaseDaggerVmFragment<FragmentHomeBinding,HomeViewModel.Factory>(),BaseClickHolder.ItemClickListener {

    companion object{
        private const val TAG = "PublicChildFragment"
        private const val EXERA_ID = "author_id"
        fun newInstance(id:Int):PublicChildFragment{
            return PublicChildFragment().apply {
                arguments = bundleOf(EXERA_ID to id)
            }
        }
    }

    private val viewModel:HomeViewModel by activityViewModels { factory }
    private val adapter = PubListAdapter(this)


    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = adapter
        binding.recyclerview.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {

            val id = arguments?.getInt(EXERA_ID,0)
            val flow = viewModel.getPublicList(id!!)
            flow.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun <V : ViewDataBinding,T> onItemClick(view: View, binding: V, position: Int,data:T) {
            logDebug(TAG,"itemClickPosition=$position")
            val publicList = data as PublicList
            startNewActivity<DetailsActivity> {
                putExtra(DetailsActivity.KEY_URL,publicList.link)
            }
    }
}