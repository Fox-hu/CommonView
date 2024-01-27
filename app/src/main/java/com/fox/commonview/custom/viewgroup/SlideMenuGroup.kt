package com.fox.commonview.custom.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import androidx.customview.widget.ViewDragHelper
import java.lang.Integer.min

/**
 * 仿qq侧滑主页面
 * @Author fox.hu
 * @date 2024/1/27
 */

class SlideMenuGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var mainView: View? = null
    private var menuView: View? = null
    private var menuViewWidth = 500

    private val viewDragHelper: ViewDragHelper by lazy {
        ViewDragHelper.create(this, object : ViewDragHelper.Callback() {
            override fun tryCaptureView(child: View, pointerId: Int): Boolean {
                return child == mainView
            }

            override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
                if (left > 0) {
                    return min(left, menuViewWidth)
                }
                return 0
            }

            override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
                return 0
            }

            //当手指抬起时的回调
            override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
                super.onViewReleased(releasedChild, xvel, yvel)
                //手指抬起时，如果滑动距离大于菜单宽度的一半，则打开菜单，否则关闭菜单
                //注意 在smooth方法后一定要调用invalidate方法和重写computeScroll方法
                //否则无法平滑过度
                if (mainView?.left!! < menuViewWidth / 2) {
                    viewDragHelper.smoothSlideViewTo(mainView!!, 0, 0)
                } else {
                    viewDragHelper.smoothSlideViewTo(mainView!!, menuViewWidth, 0)
                }
                invalidate()
            }

            override fun onViewPositionChanged(
                changedView: View,
                left: Int,
                top: Int,
                dx: Int,
                dy: Int
            ) {
                super.onViewPositionChanged(changedView, left, top, dx, dy)
                val percent = mainView?.left!! / menuViewWidth.toFloat()
                executeAnimation(percent)
            }
        })
    }

    private fun executeAnimation(percent: Float) {
        // 设计当完全展开时 缩放比例为0.8 当完全重叠时 缩放比例为1
        // percent 的变化是0-1 所以最小值是0.8 最大值是1
        mainView?.scaleX = (1 - percent * 0.2f)
        mainView?.scaleY = (1 - percent * 0.2f)

        // 完全展开时 侧栏文字到达最大
        // 完全重叠时 从-0.5宽度的位置移到正常位置
        menuView?.scaleX = (0.5f + percent * 0.5f)
        menuView?.scaleY = (0.5f + percent * 0.5f)
        menuView?.translationX = (-menuViewWidth / 2 + menuViewWidth / 2 * percent)
    }

    //如果要滑动效果 则需要实现computeScroll方法
    override fun computeScroll() {
        super.computeScroll()
        if (viewDragHelper.continueSettling(true)) {
            invalidate()
        }
    }

    //注意顺序 一定是menu先 main后
    fun setView(
        mainView: View,
        mainLayoutParams: LayoutParams,
        menuView: View,
        menuLayoutParams: LayoutParams
    ) {
        this.menuView = menuView
        addView(menuView, menuLayoutParams)
        menuViewWidth = menuLayoutParams.width

        this.mainView = mainView
        addView(mainView, mainLayoutParams)
    }

    fun closeMenu() {
        viewDragHelper.smoothSlideViewTo(mainView!!, 0, 0)
        ViewCompat.postInvalidateOnAnimation(this)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return viewDragHelper.shouldInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        viewDragHelper.processTouchEvent(event)
        return true
    }

}