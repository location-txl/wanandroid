package com.location.wanandroid.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.location.base.*
import com.location.base.recyclerview.BaseViewHolder
import com.location.wanandroid.*
import com.location.wanandroid.BR
import com.location.wanandroid.R
import com.location.wanandroid.data.MeSettingsData
import com.location.wanandroid.databinding.FragmentMeBinding
import com.location.wanandroid.databinding.ItemMeSettingsBinding
import com.location.wanandroid.databinding.ItemUserinfoBinding
import com.location.wanandroid.view.collect.CollectActivity
import com.location.wanandroid.viewmodels.UserViewModel
import kotlinx.coroutines.launch

/**
 *
 * @author tianxiaolong
 * time：2021/3/2 10:18 PM
 * description：
 */
class MeSettingFragment : BaseDaggerVmFragment<FragmentMeBinding,UserViewModel.Factory>(),
    SettingViewListener {

    companion object {
        private const val LOGOUT_POSITION = 6
        private const val COLLECT_POSITION = 2
    }



    private val model: UserViewModel by activityViewModels{factory}
    private val adapter: Adapter by lazy {
        Adapter(
            titles,
            userInfo,
            this@MeSettingFragment
        )
    }
    private val userInfo =
        SettingUser()
    override val layoutId: Int
        get() = R.layout.fragment_me

    private val titles by lazy {
        mutableListOf(
            MeSettingsData(title = "我的积分"),
            MeSettingsData(title = "我的分享"),
            MeSettingsData(title = "我的收藏"),
            MeSettingsData(title = "稍后再读"),
            MeSettingsData(title = "阅读历史"),
            MeSettingsData(title = "系统设置"),
            MeSettingsData(title = "退出登陆")
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //模拟数据
        binding.recyclerview.adapter = adapter
        refreshLoginState()
        UserManager.userState.observe(viewLifecycleOwner, Observer {
            if (it == UserState.LOGOUT || it == UserState.LOGIN) {
                refreshLoginState()

            }
        })


    }

    private fun refreshLoginState() {
        lifecycleScope.launchWhenCreated {

            if (UserManager.isLogin()) {
                userInfo.id = UserManager.readUserId()
                userInfo.userName = UserManager.readUserName()
                userInfo.userHead = UserManager.readUserHead()
                userInfo.isLogin = true
                adapter.notifyItemChanged(0)
            }else{
                userInfo.isLogin = false
                adapter.notifyItemChanged(0)
            }

        }
    }


    class Adapter(
        val datas: List<MeSettingsData>,
        var userInfo: SettingUser,
        val listener: SettingViewListener
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        companion object {
            private const val TYPE_CONTENT = 0x001
            private const val TYPE_TITLE = 0x002
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return when (viewType) {
                TYPE_CONTENT -> ViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_me_settings,
                        parent,
                        false
                    )
                ) {
                    listener.onItemClickener(data = datas[it - 1], position = it - 1)
                }
                TYPE_TITLE -> HeadViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_userinfo,
                        parent,
                        false
                    )
                ) {
                    listener.onLogin()
                }
                else -> throw IllegalArgumentException("create viewHolder error viewType is $viewType")
            }
        }

        override fun getItemCount() = datas.size + 1


        override fun getItemViewType(position: Int): Int {
            if (position == 0) {
                return TYPE_TITLE
            }
            return TYPE_CONTENT
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is ViewHolder -> holder.onBind(data = datas[position - 1])
                is HeadViewHolder -> holder.onBind(data = userInfo)
            }
        }

    }

    class ViewHolder(binding: ItemMeSettingsBinding, val onClick: (Int) -> Unit) :
        BaseViewHolder<ItemMeSettingsBinding, MeSettingsData>(binding) {

        init {
            itemView.setOnClickListener {
                onClick(layoutPosition)
            }
        }

        override fun onBind(data: MeSettingsData) {
            binding.data = data
            binding.notifyPropertyChanged(BR.data)
        }

    }

    class HeadViewHolder(binding: ItemUserinfoBinding, val login: () -> Unit) :
        BaseViewHolder<ItemUserinfoBinding, SettingUser>(binding) {

        init {

            binding.goToLogin.setOnClickListener {
                login()
            }
        }

        override fun onBind(data: SettingUser) {
            binding.userInfo = data
            binding.notifyPropertyChanged(BR.userInfo)
        }

    }

    data class SettingUser(
        var id: Int = 0,
        var userName: String? = null,
        var userHead: String? = null,
        var isLogin: Boolean = false
    )

    override fun onLogin() {
        startNewActivity<MainActivity>()
    }

    private fun logout(){
        model.logout().observe(viewLifecycleOwner, Observer {
            if (it.isSuccess()) {
                lifecycleScope.launch {
                    UserManager.clearLogin()
                    toast("退出登陆成功")
                }

            }
        })
    }
    private inline fun checkLogin(crossinline block:()->Unit){
        lifecycleScope.launchWhenCreated {
            if(UserManager.isLogin()){
                block()
            }else{
                onLogin()
            }
        }
    }

    override fun onItemClickener(data: MeSettingsData, position: Int) {
        when (position) {
            LOGOUT_POSITION -> logout()
            COLLECT_POSITION -> {
                checkLogin{
                    startNewActivity<CollectActivity>()
                }
            }
        }
    }


}

interface SettingViewListener {
    fun onLogin()
    fun onItemClickener(data: MeSettingsData, position: Int)
}