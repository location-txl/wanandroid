package com.location.dependencies

import com.location.dependencies.Versions.activity_version
import com.location.dependencies.Versions.arouter_compiler_version
import com.location.dependencies.Versions.arouter_version
import com.location.dependencies.Versions.data_store
import com.location.dependencies.Versions.glide_version
import com.location.dependencies.Versions.leakCanary_version
import com.location.dependencies.Versions.okhttp_log_version
import com.location.dependencies.Versions.paging_version
import com.location.dependencies.Versions.persistentCookieJar
import com.location.dependencies.Versions.fragment_version
import com.location.dependencies.Versions.constraintlayout_version
import com.location.dependencies.Versions.dagger_version
import com.location.dependencies.Versions.lifecycle_version
import com.location.dependencies.Versions.navigation_version
import com.location.dependencies.Versions.retrofit_version
import com.location.dependencies.Versions.moshi_version
import com.location.dependencies.Versions.room_version


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
    const val version_name = "1.0.1"

}

object  Versions{
    const val kotlin = "_"
    const val core_ktx_version = "_"
    const val appcompat_version = "_"
    const val material_version = "_"
    const val junit_version = "_"
    const val activity_version = "_"
    const val android_junit_version = "_"
    const val espresso_core_version = "_"
    const val lifecycle_version = "_"
    const val startup_version = "_"
    const val fragment_version = "_"
    const val navigation_version = "_"
    const val coroutines_version = "_"
    const val data_store = "_"
    const val paging_version = "_"
    const val glide_version = "_"
    const val okhttp_log_version = "_"
    const val persistentCookieJar = "v1.0.1"
    const val leakCanary_version = "_"
    const val constraintlayout_version = "_"
    const val retrofit_version = "_"
    const val moshi_version = "_"
    const val dagger_version = "_"
    const val room_version = "_"
    const val arouter_version = "_"
    const val arouter_compiler_version = "_"

}
object SampleConfig{
    const val activitySampleModel = false
    const val viewSampleModel = false
}

object Deps {
    const val  DATA_STORE  = "androidx.datastore:datastore-preferences:$data_store"
    const val  PADING = "androidx.paging:paging-runtime:_"
    const val  GLIDE = "com.github.bumptech.glide:glide:_"
    const val  GLIDE_COMPILER = "com.github.bumptech.glide:compiler:_"
    const val  OKHTTP_LOG = "com.squareup.okhttp3:logging-interceptor:_"
    const val  COOKIE = "com.github.franmontiel:PersistentCookieJar:${persistentCookieJar}"
    const val  LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:_"
    const val  fragment = "androidx.fragment:fragment-ktx:_"
    const val  constraintlayout = "androidx.constraintlayout:constraintlayout:_"
    
    const val  lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:_"
    const val  lifecycle_common = "androidx.lifecycle:lifecycle-common-java8:_"
    const val  viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:_"
    const val  viewModelSaveState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:_"
    const val  lifecycleScop = "androidx.lifecycle:lifecycle-runtime-ktx:_"
    
    const val  navigationFragment = "androidx.navigation:navigation-fragment-ktx:_"
    const val  navigationUI = "androidx.navigation:navigation-ui-ktx:_"

    const val  retrofit = "com.squareup.retrofit2:retrofit:_"
    const val  retrofitCoroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:_"
    const val  retrofitRxJava2Adapter = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:_"
    const val  retrofitMoshiConvert = "com.squareup.retrofit2:converter-moshi:_"
    const val  moshi = "com.squareup.moshi:moshi-kotlin:_"
    const val moshiCode = "com.squareup.moshi:moshi-kotlin-codegen:_"
    const val webViewX5 = "com.tencent.tbs.tbssdk:sdk:43939"

    const val dagger = "com.google.dagger:dagger:_"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:_"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:_"
    const val daggerAndroid = "com.google.dagger:dagger-android:_"
    const val daggerAndroidCompiler = "com.google.dagger:dagger-android-processor:_"

    const val room = "androidx.room:room-runtime:_"
    const val roomCompiler = "androidx.room:room-compiler:_"
    const val roomKtx = "androidx.room:room-ktx:_"

    const val activity = "androidx.activity:activity-ktx:_"
    const val arouterApi = "com.alibaba:arouter-api:_"
    const val arouterCompilerApi = "com.alibaba:arouter-compiler:_"
}
