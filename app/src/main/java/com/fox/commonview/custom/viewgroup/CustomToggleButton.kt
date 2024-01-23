package com.fox.commonview.custom.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Scroller
import com.fox.commonview.R

/**
 * @Author fox.hu
 * @Date 2024/1/22 22:23
 * 一个自定义的ToggleButton 用于展示scroller的使用
 * 1. 初始化一个scroller
 * 2. 调用scroller.startScroll()方法
 * 3. 重写computeScroll()方法 在computeScroll中处理scroller计算出来的值
 */
class CustomToggleButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private val scroller: Scroller = Scroller(context)
    private var isOpen = false
    private var slideWidth = 0
    private var scrollerWidth = 0

    init {
        setBackgroundResource(R.drawable.background)

        val slide = ImageView(context)
        slide.setBackgroundResource(R.drawable.slide)
        setOnClickListener {
            if (!isOpen) {
                //当关闭时 点击打开 滑块向右滑动 起始位置是0 向右则为负数 大小为scrollerWidth
                scroller.startScroll(0, 0, -scrollerWidth, 0, 500)
            } else {
                //当打开时 点击关闭 滑块向左滑动 起始位置是-scrollerWidth 向左则为正数 大小为scrollerWidth
                scroller.startScroll(-scrollerWidth, 0, scrollerWidth, 0, 500)
            }
            isOpen = !isOpen
            invalidate()
        }
        addView(slide)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        resources.getDrawable(R.drawable.background).apply {
            setMeasuredDimension(intrinsicWidth, intrinsicHeight)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        slideWidth = measuredWidth / 2
        scrollerWidth = measuredWidth - slideWidth
        getChildAt(0).layout(0, 0, slideWidth, measuredHeight)
    }

    //一定要重写这个方法 不然滑动不了
    //需要在这个方法中实际调用scrollTo方法 进行滑动 滑动的参数就是scroller计算出来的值
    override fun computeScroll() {
        super.computeScroll()
        if(scroller.computeScrollOffset()) {
            scrollTo(scroller.currX, scroller.currY)
            invalidate()
        }
    }
}