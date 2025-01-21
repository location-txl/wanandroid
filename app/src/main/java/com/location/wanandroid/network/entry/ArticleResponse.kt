package com.location.androidsample.wanandroid.entry

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

/**
 * "offset": 20,
 *         "over": false,
 *         "pageCount": 797,
 *         "size": 20,
 *         "total": 15937
 */
@Serializable
data class ArticleResponse(
    @SerialName("curPage") val curPage: Int,
    @SerialName("datas") val datas: List<ArticleItem>,
    @SerialName("offset") val offset: Int,
    @SerialName("over") val over: Boolean,
    @SerialName("pageCount") val pageCount: Int,
    @SerialName("size") val size: Int,
    @SerialName("total") val total: Int
)


@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonIgnoreUnknownKeys
data class ArticleItem(
    @SerialName("author") val author: String,
    @SerialName("chapterId") val chapterId: Int,
    @SerialName("chapterName") val chapterName: String,
    @SerialName("collect") val collect: Boolean,
    @SerialName("courseId") val courseId: Int,
    @SerialName("envelopePic") val envelopePic: String,
    @SerialName("fresh") val fresh: Boolean,
    @SerialName("id") val id: Int,
    @SerialName("link") val link: String,
    @SerialName("niceDate") val niceDate: String,
    @SerialName("niceShareDate") val niceShareDate: String,
    @SerialName("publishTime") val publishTime: Long,
    @SerialName("realSuperChapterId") val realSuperChapterId: Int,
    @SerialName("selfVisible") val selfVisible: Int,
    @SerialName("shareDate") val shareDate: Long,
    @SerialName("shareUser") val shareUser: String,
    @SerialName("superChapterId") val superChapterId: Int,
    @SerialName("superChapterName") val superChapterName: String,
    @SerialName("tags") val tags: List<Tag>,
    @SerialName("title") val title: String,
    @SerialName("type") val type: Int,
    @SerialName("userId") val userId: Int,
)

@Serializable
data class Tag(
    @SerialName("name") val name: String, @SerialName("url") val url: String
)


