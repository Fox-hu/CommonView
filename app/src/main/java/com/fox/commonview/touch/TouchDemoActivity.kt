package com.fox.commonview.touch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.fox.commonview.R

class TouchDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch)
    }

    companion object{
        const val TAG = "TouchDemoActivity"
    }

    //return super:传给下一级view(viewGroup)的dispatchTouchEvent
    //return true/false:消费掉事件，终止传递 (不传递给onTouchEvent)
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i(TAG,"MainActivity dispatchTouchEvent return super")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG,"MainActivity onTouchEvent return super")
        return super.onTouchEvent(event)
    }
}