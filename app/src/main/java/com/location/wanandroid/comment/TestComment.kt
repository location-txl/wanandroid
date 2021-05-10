package com.location.wanandroid.comment

import com.location.wanandroid.module.TestModel
import com.location.wanandroid.test.TestInject
import com.location.wanandroid.view.home.HomeActivity
import dagger.Component
import javax.inject.Singleton

/**
 *
 * @author tianxiaolong
 * time：4/27/21 11:29 PM
 * description：
 */
@Component(modules = [TestModel::class])
interface TestComment {
    fun inject(home: TestInject)
}