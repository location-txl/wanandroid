package com.location.sample

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View

/**
 *
 * @author tianxiaolong
 * time：2021/2/21 2:38 PM
 * description：
 * bitmap 是位图信息存储工具 简单灵活
 * drawable 是可以用canvas绘制的上层工具 drawable只负责绘制
 */


public  class DrawableView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){

    var drawable:Drawable = ColorDrawable(Color.RED)
    set(value) {
        field = value
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        drawable.setBounds(0,0,width,height)
        drawable.draw(canvas)
    }
}

class CustomDrawbale:Drawable(){
    private  val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }
    override fun draw(canvas: Canvas) {
        canvas.drawCircle(bounds.width()/2.toFloat(),bounds.height()/2.toFloat(),bounds.width()/2.toFloat(),paint)
    }

    /**
     * 透明度
     */
    override fun setAlpha(alpha: Int) {
        paint.alpha  = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    /**
     * 不透明度
     */
    override fun getOpacity(): Int {
       return when(paint.alpha){
           0 -> PixelFormat.TRANSPARENT
           0xff -> PixelFormat.OPAQUE
           else -> PixelFormat.TRANSLUCENT
       }
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getColorFilter(): ColorFilter? {
        return paint.colorFilter
    }

}


