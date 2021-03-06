package com.location.wanandroid

import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.location.base.logDebug
import com.location.wanandroid.widget.FavoritesView

/**
 *
 * @author tianxiaolong
 * time：2021/2/28 4:55 PM
 * description：
 * DataBinding扩展
 */

@BindingAdapter("imageUrl")
fun loadImage(view:ImageView,url:String?){
    url?.let {


        Glide.with(view).load(url).error(R.drawable.logo).override(263).centerCrop()
            .into(view)
    }

}

@BindingAdapter("htmlText")
fun htmlText(view:TextView,text:String){
    view.text = HtmlCompat.fromHtml(text,HtmlCompat.FROM_HTML_MODE_LEGACY)
}

@BindingAdapter("favorChecked")
fun checked(view:FavoritesView,checked:Boolean){
    view.setState(checked)
}