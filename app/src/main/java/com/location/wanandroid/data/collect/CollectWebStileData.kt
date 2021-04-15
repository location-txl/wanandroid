package com.location.wanandroid.data.collect
import androidx.recyclerview.widget.DiffUtil
import com.location.wanandroid.data.WanResponse
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


/**
 *
 * @author tianxiaolong
 * time：4/15/21 9:56 PM
 * description：
 */

typealias CollectWebSliteData = WanResponse<List<CollectWebSlite>>

@JsonClass(generateAdapter = true)
data class CollectWebSlite(
    @Json(name = "desc")
    val desc: String,
    @Json(name = "icon")
    val icon: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "link")
    val link: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "order")
    val order: Int,
    @Json(name = "userId")
    val userId: Int,
    @Json(name = "visible")
    val visible: Int
){

    class DiffCallback: DiffUtil.ItemCallback<CollectWebSlite>() {
        override fun areItemsTheSame(
            oldItem: CollectWebSlite,
            newItem: CollectWebSlite
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CollectWebSlite,
            newItem: CollectWebSlite
        ): Boolean {
            return oldItem == newItem
        }
    }
}