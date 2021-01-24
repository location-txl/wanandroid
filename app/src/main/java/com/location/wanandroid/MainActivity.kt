package com.location.wanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.location.wanandroid.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private  val userModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Fragment
//        supportFragmentManager.commit {
//
//        }
        userModel.login()

    }
}