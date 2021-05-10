package com.location.wanandroid.test

import com.location.wanandroid.comment.DaggerTestComment
import com.location.wanandroid.data.DaggerData
import javax.inject.Inject

/**
 *
 * @author tianxiaolong
 * time：4/27/21 11:33 PM
 * description：
 */
class TestInject {
    @Inject
    lateinit var data1: DaggerData

    @Inject
    lateinit var data2: DaggerData
    fun injectDagger(){
        DaggerTestComment.create().inject(this)
    }
}