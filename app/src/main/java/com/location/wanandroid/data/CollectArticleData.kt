package com.location.wanandroid.data
import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


/**
 *
 * @author tianxiaolong
 * time：2021/3/6 5:49 PM
 * description：
 */

typealias WanCollectArticle = WanResponse<CollectArticleData>

typealias CollectArticleData = PageData<CollectArticleItem>

@JsonClass(generateAdapter = true)
data class CollectArticleItem(
    @Json(name = "author")
    val author: String,
    @Json(name = "chapterId")
    val chapterId: Int,
    @Json(name = "chapterName")
    val chapterName: String,
    @Json(name = "courseId")
    val courseId: Int,
    @Json(name = "desc")
    val desc: String,
    @Json(name = "envelopePic")
    val envelopePic: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "link")
    val link: String,
    @Json(name = "niceDate")
    val niceDate: String,
    @Json(name = "origin")
    val origin: String,
    @Json(name = "originId")
    val originId: Int,
    @Json(name = "publishTime")
    val publishTime: Long,
    @Json(name = "title")
    val title: String,
    @Json(name = "userId")
    val userId: Int,
    @Json(name = "visible")
    val visible: Int,
    @Json(name = "zan")
    val zan: Int



){


    class DiffCallback: DiffUtil.ItemCallback<CollectArticleItem>() {
        override fun areItemsTheSame(
            oldItem: CollectArticleItem,
            newItem: CollectArticleItem
        ): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CollectArticleItem,
            newItem: CollectArticleItem
        ): Boolean {
           return oldItem == newItem
        }

    }
}