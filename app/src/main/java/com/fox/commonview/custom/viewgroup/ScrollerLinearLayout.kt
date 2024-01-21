package com.fox.commonview.custom.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.Scroller

/**
 * @Author fox.hu
 * @Date 2021/1/20 17:23
 */
class ScrollerLinearLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val scroller by lazy {
        Scroller(context)
    }


    /**
     * 只允许横向滚动
     */
    fun startScroll(startX: Int, dx: Int) {
        scroller.startScroll(startX, 0, dx, 0)
        invalidate()
    }

    /**
     * 重写computeScroll方法 从scroller计算结果中获取当前的滚动位置
     */
    override fun computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.currX, scroller.currY)
            invalidate()
        }
    }
}