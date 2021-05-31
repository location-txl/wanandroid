package com.location.viewsample

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TouchDelegate
import android.widget.Toast
import com.location.viewsample.R
import com.location.viewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflate = ActivityMainBinding.inflate(layoutInflater)
        setContentView(inflate.root)
        inflate.delegateView.post {
            val delegateView = inflate.touchDelegateButton
            inflate.delegateView.touchDelegate = TouchDelegate(
                Rect(
                    0,
                    0,
                    inflate.delegateView.measuredWidth,
                    inflate.delegateView.measuredHeight
                ), delegateView
            )
        }

        inflate.touchDelegateButton.setOnClickListener {
            Toast.makeText(this, "delegateView点击", Toast.LENGTH_SHORT).show()
        }

    }
}