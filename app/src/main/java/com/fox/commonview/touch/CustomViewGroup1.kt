package com.fox.commonview.touch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.RelativeLayout

class CustomViewGroup1  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr){

    companion object{
        const val TAG = "CustomViewGroup1"
    }

    //return super:传给自己的onInterceptTouchEvent()
    //return false:将事件传递给上一级View的onTouchEvent()方法
    //return true:消费掉事件，终止传递 (不传递给onTouchEvent)
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i(TAG,"CustomViewGroup1 dispatchTouchEvent return super")
        return super.dispatchTouchEvent(ev)
    }

    //return true:将事件传递给ViewGroup自己的onTouchEvent()方法处理。
    //return false/super:将事件传递给下一级View的dispatchTouchEvent()。
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.i(TAG,"CustomViewGroup1 onInterceptTouchEvent return super")
        return super.onInterceptTouchEvent(ev)
    }

    //return true:消费掉事件，终止传递。
    //return false/super:将事件传递给上一级view的onTouchEvent()方法。
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG,"CustomViewGroup1 onTouchEvent return super")
        return super.onTouchEvent(event)
    }
}