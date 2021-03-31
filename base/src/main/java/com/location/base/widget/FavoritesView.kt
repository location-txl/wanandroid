package com.location.base.widget

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable
import androidx.core.graphics.withSave
import kotlin.math.min

private const val ANIMATOR_DURATION = 1000L

class FavoritesView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), Checkable {
    private var size = 0f
    private var heartSize = 0f
    private val path = Path()
    private val rect = RectF()
    private var checked = false
    private val animator = ObjectAnimator.ofFloat(this, "proportion", 0f, 1f).apply {
        duration = ANIMATOR_DURATION
    }
    private var proportion = 1.0f
        set(value) {
            field = value
            invalidate()
        }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        size = (width - paddingLeft - paddingRight).toFloat() / 8 * 7
        heartSize = (width - paddingLeft - paddingRight).toFloat() / 8 * 4
        rect.set(0f, 0f, heartSize*2, size)
        path.apply {
            reset()
            addArc(0f, 0f, heartSize, heartSize, -225f, 225f)
            arcTo(heartSize, 0f, heartSize * 2, heartSize, -180f, 225f, false)
            lineTo(heartSize, size)
            close()
        }
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas) {
        canvas.withSave {
            translate(paddingLeft.toFloat(),paddingTop.toFloat())
            clipPath(path)
            paint.style = Paint.Style.STROKE
            canvas.drawPath(path, paint)
            paint.style = Paint.Style.FILL
            if (proportion > 0f) {
                canvas.drawRect(rect.left, rect.top, rect.right, rect.bottom * proportion, paint)
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

    private fun changeState(checked:Boolean,showAnim:Boolean){
        this.checked = checked
        if(showAnim){
            if(animator.isRunning){
                animator.pause()
            }
            if (checked) {
                animator.start()
            } else {
                animator.reverse()
            }
        }else{
            proportion = if(checked){
                1.0f
            }else{
                0.0f
            }
            invalidate()
        }
    }

    override fun isChecked() = checked

    override fun toggle() {
        changeState(!checked,true)
    }

    override fun setChecked(checked: Boolean) {
            toggle()
    }

    fun setState(checked:Boolean){
            changeState(checked,false)
    }

}