package com.fox.commonview.custom.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.fox.commonview.R

/**
 * @Author fox.hu
 * @Date 2021/1/20 17:23
 */
class DirectionView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {

    private var lastX = 0
    private var lastY = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_direction_view, this)
        findViewById<ImageView>(R.id.direction_up).setOnClickListener(this)
        findViewById<ImageView>(R.id.direction_down).setOnClickListener(this)
        findViewById<ImageView>(R.id.direction_left).setOnClickListener(this)
        findViewById<ImageView>(R.id.direction_right).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.direction_up -> {
                Toast.makeText(context, "up", Toast.LENGTH_SHORT).show()
            }

            R.id.direction_down -> {
                Toast.makeText(context, "down", Toast.LENGTH_SHORT).show()
            }

            R.id.direction_left -> {
                Toast.makeText(context, "left", Toast.LENGTH_SHORT).show()
            }

            R.id.direction_right -> {
                Toast.makeText(context, "right", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * 在onInterceptTouchEvent方法中 我们在down中记录下手指的坐标
     * 在move中拦截事件 转交给自己的onTouchEvent方法处理
     */
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = ev.x.toInt()
                lastY = ev.y.toInt()
            }

            MotionEvent.ACTION_MOVE -> {
                return true
            }
        }
        return false
    }

    /**
     * 在onTouchEvent方法中
     * 在move中计算出手指移动的距离
     * 然后根据手指的移动距离来更新View的位置
     */
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_MOVE -> {
                val offX = event.x - lastX
                val offY = event.y - lastY
                val params = layoutParams as LayoutParams
                params.leftMargin = (left + offX).toInt()
                params.topMargin = (top + offY).toInt()
                layoutParams = params
                return true
            }
        }
        return super.onTouchEvent(event)
    }
}