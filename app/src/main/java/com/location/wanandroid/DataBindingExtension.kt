package com.location.wanandroid

import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *
 * @author tianxiaolong
 * time：2021/2/28 4:55 PM
 * description：
 * DataBinding扩展
 */

@BindingAdapter("imageUrl")
fun loadImage(view:ImageView,url:String){
    Glide.with(view).load(url).error(R.drawable.logo).centerCrop()
        .into(view)
}

@BindingAdapter("htmlText")
fun htmlText(view:TextView,text:String){
    view.text = HtmlCompat.fromHtml(text,HtmlCompat.FROM_HTML_MODE_LEGACY)
}