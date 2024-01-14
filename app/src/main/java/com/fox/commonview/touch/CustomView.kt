package com.fox.commonview.touch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    companion object{
        const val TAG = "CustomView"
    }

    //return super:传给自己的onTouchEvent()
    //return false:将事件传递给上一级View的onTouchEvent()方法
    //return true:消费掉事件，终止传递 (不传递给onTouchEvent)
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i(TAG,"CustomView dispatchTouchEvent return super")
        return super.dispatchTouchEvent(ev)
    }

    //return true:消费掉事件，终止传递。
    //return false/super:将事件传递给上一级view的onTouchEvent()方法。
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG,"CustomView onTouchEvent return super")
        return super.onTouchEvent(event)
    }
}
