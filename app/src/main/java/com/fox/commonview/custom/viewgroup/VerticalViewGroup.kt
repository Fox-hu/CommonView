package com.fox.commonview.custom.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import kotlin.math.max

/**
 * @Author fox
 * @Date 2024/1/18 23:18
 * 1.因onMeasure的onMeasure方法 实际是View的onMeasure方法 只会测量自己 并不会测量子控件
 *   所以我们需要重写onMeasure方法 并处理wrap_content的情况
 * 2.因为我们的自定义ViewGroup是一个容器 所以我们需要重写onLayout方法 并在其中对子控件进行布局
 */
class VerticalViewGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        measureChildren(widthMeasureSpec,heightMeasureSpec)

        //获取控件的最大宽度和总高度
        var maxWidth = 0
        var height = 0
        for (i in 0..childCount) {
            getChildAt(i)?.apply {
                val childWidth = measuredWidth
                maxWidth = max(maxWidth,childWidth)
                val childHeight = measuredHeight
                height += childHeight
            }
        }

        //处理wrap content的场景
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        if(widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(maxWidth, height)
        } else if (widthMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(maxWidth, heightSize)
        } else if (heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize, height)
        } else {
            setMeasuredDimension(widthSize, heightSize)
        }
    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        var top = 0
        for (i in 0..childCount) {
            getChildAt(i)?.apply {
                //如果不复写 onMeasure方法 则 measuredHeight 和 measuredWidth 都是0
                val width = measuredWidth
                val height = measuredHeight
                layout(0, top, width, top + height)
                top += height
            }
        }
    }

}