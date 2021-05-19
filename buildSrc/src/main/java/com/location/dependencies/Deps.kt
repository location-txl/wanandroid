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
    const val version_name = "1.0.0"

}

object  Versions{
    const val kotlin = "1.3.72"
    const val core_ktx_version = "1.3.2"
    const val appcompat_version = "1.2.0"
    const val material_version = "1.2.1"
    const val junit_version = "4.13.1"
    const val activity_version = "1.2.2"
    const val android_junit_version = "1.1.2"
    const val espresso_core_version = "3.3.0"
    const val lifecycle_version = "2.2.0"
    const val startup_version = "1.0.0"
    const val fragment_version = "1.2.5"
    const val navigation_version = "2.3.2"
    const val coroutines_version = "1.3.0"
    const val data_store = "1.0.0-alpha06"
    const val paging_version = "3.0.0-alpha13"
    const val glide_version = "4.12.0"
    const val okhttp_log_version = "3.5.0"
    const val persistentCookieJar = "v1.0.1"
    const val leakCanary_version = "2.6"
    const val constraintlayout_version = "2.0.4"
    const val retrofit_version = "2.9.0"
    const val moshi_version = "1.8.0"
    const val dagger_version = "2.33"
    const val room_version = "2.2.6"
    const val arouter_version = "1.4.0"
    const val arouter_compiler_version = "1.2.1"

}

object SampleConfig{
    const val activitySampleModel = true
}

object Deps {
    const val  DATA_STORE  = "androidx.datastore:datastore-preferences:$data_store"
    const val  PADING = "androidx.paging:paging-runtime:$paging_version"
    const val  GLIDE = "com.github.bumptech.glide:glide:$glide_version"
    const val  GLIDE_COMPILER = "com.github.bumptech.glide:compiler:$glide_version"
    const val  OKHTTP_LOG = "com.squareup.okhttp3:logging-interceptor:$okhttp_log_version"
    const val  COOKIE = "com.github.franmontiel:PersistentCookieJar:${persistentCookieJar}"
    const val  LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:$leakCanary_version"
    const val  fragment = "androidx.fragment:fragment-ktx:$fragment_version"
    const val  constraintlayout = "androidx.constraintlayout:constraintlayout:$constraintlayout_version"
    
    const val  lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    const val  lifecycle_common = "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
    const val  viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    const val  viewModelSaveState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
    const val  lifecycleScop = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"
    
    const val  navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigation_version"
    const val  navigationUI = "androidx.navigation:navigation-ui-ktx:$navigation_version"

    const val  retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
    const val  retrofitCoroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    const val  retrofitRxJava2Adapter = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0"
    const val  retrofitMoshiConvert = "com.squareup.retrofit2:converter-moshi:2.9.0"
    const val  moshi = "com.squareup.moshi:moshi-kotlin:$moshi_version"
    const val moshiCode = "com.squareup.moshi:moshi-kotlin-codegen:$moshi_version"
    const val webViewX5 = "com.tencent.tbs.tbssdk:sdk:43939"

    const val dagger = "com.google.dagger:dagger:$dagger_version"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:$dagger_version"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:$dagger_version"
    const val daggerAndroid = "com.google.dagger:dagger-android:$dagger_version"
    const val daggerAndroidCompiler = "com.google.dagger:dagger-android-processor:$dagger_version"

    const val room = "androidx.room:room-runtime:$room_version"
    const val roomCompiler = "androidx.room:room-compiler:$room_version"
    const val roomKtx = "androidx.room:room-ktx:$room_version"

    const val activity = "androidx.activity:activity-ktx:$activity_version"
    const val arouterApi = "com.alibaba:arouter-api:$arouter_version"
    const val arouterCompilerApi = "com.alibaba:arouter-compiler:$arouter_compiler_version"
}
