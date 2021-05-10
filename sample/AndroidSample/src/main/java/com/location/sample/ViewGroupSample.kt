package com.location.sample

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.math.max

/**
 *
 * @author tianxiaolong
 * time：2021/2/21 3:30 PM
 * description：
 */
class ViewGroupSample @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {
    private val childBounds = mutableListOf<Rect>()
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for ((index,child) in  children.withIndex()){

            val bounds = childBounds[index]
            child.layout(bounds.left,bounds.top,bounds.right,bounds.bottom)
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSpecMode = MeasureSpec.getMode(widthMeasureSpec)
        val maxGroupWidth = when(widthSpecMode){
            MeasureSpec.AT_MOST,MeasureSpec.EXACTLY -> MeasureSpec.getSize(widthMeasureSpec)
            else -> 0
        }
        var currentWidth = 0
        var maxWidth = 0
        var totalLineHeight = 0
        var currentMaxHeight = 0
        for ((index,child) in  children.withIndex()){
            measureChildWithMargins(child,widthMeasureSpec,0,heightMeasureSpec,totalLineHeight)
            if(widthSpecMode != MeasureSpec.UNSPECIFIED && (currentWidth + child.measuredWidth )> maxGroupWidth){
                //next line
                currentWidth = 0
                totalLineHeight+=currentMaxHeight
                currentMaxHeight = 0
                measureChildWithMargins(child,widthMeasureSpec,0,heightMeasureSpec,totalLineHeight)
            }
            if(index >= childBounds.size){
                childBounds.add(Rect())
            }
            val rectBounds = childBounds[index]
            rectBounds.set(currentWidth,totalLineHeight,currentWidth+child.measuredWidth,totalLineHeight+child.measuredHeight)
            currentWidth+=child.measuredWidth
            maxWidth = max(maxWidth,currentWidth)
            currentMaxHeight = max(currentMaxHeight,child.measuredHeight)
        }
        totalLineHeight += currentMaxHeight

        setMeasuredDimension(resolveSize(maxWidth,widthMeasureSpec),resolveSize(totalLineHeight,heightMeasureSpec))
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context,attrs)
    }
}