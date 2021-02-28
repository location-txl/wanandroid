package com.location.sample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewConfiguration
import kotlin.math.log

/**
 *
 * @author tianxiaolong
 * time：2021/2/21 4:03 PM
 * description：
 */
class ProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private  val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        super.layout(l, t, l+100, b)
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        ViewConfiguration.getDoubleTapTimeout()
       Log.d("ProgressView","width=$width")
       Log.d("ProgressView","measureWidth=$measuredWidth")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

}