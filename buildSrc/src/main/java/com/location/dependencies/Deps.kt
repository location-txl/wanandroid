package com.location.dependencies

import com.location.dependencies.Versions.data_store
import com.location.dependencies.Versions.glide_version
import com.location.dependencies.Versions.paging_version


/**
 *
 * @author tianxiaolong
 * time：2021/1/28 11:00 PM
 * description：
 */

object AppConfig{
    const val APPLICATION_ID = "com.location.wanandroid"
    const val compile_version = 30
    const val build_tool_version = "30.0.3"
    const val min_sdk_version = 27
    const val target_sdk_version = 30
    const val IS_BINDING = true
    const val version_code = 1
    const val version_name = "1.0.0"

}
object  Versions{
    const val kotlin = "1.3.72"
    const val core_ktx_version = "1.3.2"
    const val appcompat_version = "1.2.0"
    const val material_version = "1.2.1"
    const val junit_vrsion = "4.13.1"
    const val espresso_core_version = "3.3.0"
    const val lifecycle_version = "2.2.0"
    const val startup_version = "1.0.0"
    const val fragment_version = "1.2.5"
    const val navigation_version = "2.3.2"
    const val coroutines_version = "1.3.0"
    const val data_store = "1.0.0-alpha06"
    const val paging_version = "3.0.0-alpha13"
    const val glide_version = "4.12.0"
}

object Deps {
    const val  DATA_STORE  = "androidx.datastore:datastore-preferences:$data_store"
    const val  PADING = "androidx.paging:paging-runtime:$paging_version"
    const val  GLIDE = "com.github.bumptech.glide:glide:$glide_version"
    const val  GLIDE_COMPILER = "com.github.bumptech.glide:compiler:$glide_version"
}
