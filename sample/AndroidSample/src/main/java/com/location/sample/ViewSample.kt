package com.location.sample

import android.app.Activity
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.core.graphics.withSave
import androidx.recyclerview.widget.RecyclerView

class ViewSample @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private  val paint by lazy { Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.FILL
    } }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.BLACK)

        canvas.withSave {
            translate(300f,0f)
            rotate(45f)
            drawRect(0f,0f,100f,100f,paint)
        }
        canvas.drawRect(0f,0f,100f,100f,paint)
    }

    fun test(){
        val bitmap = Bitmap.createBitmap(100,100,Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.RED)
    }

    companion object{
        val name = "a"
        fun staticTest(){
            var a = TestView()
        }

    }

    /**
     * inner 加了inner后 会变成非静态的内部类
     */
    class TestView{
//        companion object {
            fun test() {
                var ab = name
            }
//        }
    }
}