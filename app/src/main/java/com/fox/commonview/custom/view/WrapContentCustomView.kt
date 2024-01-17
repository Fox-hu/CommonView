package com.fox.commonview.custom.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.fox.commonview.R

/**
 * @Author fox
 * @Date 2024/1/17 23:34
 */
class WrapContentCustomView
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mWidth: Int = 0
    private var mHeight: Int = 0
    private var mBitmap:Bitmap? = null

    init {
        mBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.common_feedback_error)
        mWidth = mBitmap?.width ?: 0
        mHeight = mBitmap?.height ?: 0
    }

    /**
     * 重写onMeasure方法，使得wrap_content生效
     * 控件宽高由父容器和子控件的测量模式共同决定
     * 可以认为
     * MeasureSpec.AT_MOST = wrap_content
     * MeasureSpec.EXACTLY = match_parent
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        if(widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(mWidth, mHeight)
        } else if (widthMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(mWidth, heightSize)
        } else if (heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize, mHeight)
        } else {
            setMeasuredDimension(widthSize, heightSize)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mBitmap?.let { canvas?.drawBitmap(it, 0f, 0f, null) }
    }
}