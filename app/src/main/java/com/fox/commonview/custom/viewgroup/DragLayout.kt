package com.fox.commonview.custom.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.customview.widget.ViewDragHelper

/**
 * ViewDragHelper 使用的示例
 * @Author fox.hu
 * @Date 2024/1/25 22:23
 */
class DragLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val dragger: ViewDragHelper = ViewDragHelper.create(this, 1.0f, object : ViewDragHelper.Callback() {

        //viewGroup中的哪个控件将被拦截触摸事件
        override fun tryCaptureView(child: View, pointerId: Int): Boolean {
            return true
        }

        //手指在子view中横向移动时 会调用此函数
        //参数中的left 就是值目前手指所在的位置 返回值则是子view新left的坐标值
        //那么返回left 就是让view跟随我们手指进行移动
        //如果不重写这个方法 那么默认返回0 效果就是一碰就跑到了最左边
        override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
            return left
        }

        //手指在子view中纵向移动时 会调用此函数
        //同横向的回调
        override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
            return top
        }

        //当子控件设置了设置了onClick事件后 DragLayout将无法拖动子控件
        //这个时候需要进行对这个方法进行设置 返回一个>0的数 使DragLayout可以拖动子控件(横向)
        override fun getViewHorizontalDragRange(child: View): Int {
            return 1
        }

        //同横向
        override fun getViewVerticalDragRange(child: View): Int {
            return 1
        }

    })

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return dragger.shouldInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        dragger.processTouchEvent(event)
        return true
    }

}