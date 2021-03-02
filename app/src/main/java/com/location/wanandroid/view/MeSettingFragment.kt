package com.location.wanandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.location.base.BaseFragment
import com.location.base.BaseViewHolder
import com.location.wanandroid.BR
import com.location.wanandroid.R
import com.location.wanandroid.data.MeSettingsData
import com.location.wanandroid.databinding.FragmentMeBinding
import com.location.wanandroid.databinding.ItemMeSettingsBinding
import com.location.wanandroid.databinding.ItemUserinfoBinding

/**
 *
 * @author tianxiaolong
 * time：2021/3/2 10:18 PM
 * description：
 */
class MeSettingFragment: BaseFragment<FragmentMeBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_me

   private val titles  by lazy { mutableListOf(
       MeSettingsData(title = "我的积分"),
       MeSettingsData(title = "我的分享"),
       MeSettingsData(title = "我的收藏"),
       MeSettingsData(title = "稍后再读"),
       MeSettingsData(title = "阅读历史"),
       MeSettingsData(title = "系统设置")
   )}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binding.recyclerview.adapter = Adapter(titles)
    }



    class Adapter(val datas:List<MeSettingsData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        companion object{
            private const val TYPE_CONTENT  = 0x001
            private const val TYPE_TITLE    = 0x002
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
           return when(viewType){
               TYPE_CONTENT -> ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_me_settings,parent,false))
               TYPE_TITLE -> HeadViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_userinfo,parent,false))
               else -> throw IllegalArgumentException("create viewHolder error viewType is $viewType")
           }
        }

        override fun getItemCount() = datas.size + 1


        override fun getItemViewType(position: Int): Int {
            if(position == 0){
                return TYPE_TITLE
            }
            return TYPE_CONTENT
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
           when(holder){
               is ViewHolder -> holder.onBind(data = datas[position - 1])
           }
        }

    }

    class ViewHolder(binding: ItemMeSettingsBinding) : BaseViewHolder<ItemMeSettingsBinding,MeSettingsData>(binding) {

        override fun onBind(data: MeSettingsData) {
            binding.data = data
            binding.notifyPropertyChanged(BR.data)
        }

    }

    class HeadViewHolder(binding: ItemUserinfoBinding) : BaseViewHolder<ItemUserinfoBinding,MeSettingsData>(binding) {

        override fun onBind(data: MeSettingsData) {

        }

    }

}