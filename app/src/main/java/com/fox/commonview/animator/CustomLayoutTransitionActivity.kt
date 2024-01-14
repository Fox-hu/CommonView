package com.fox.commonview.animator

import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.fox.commonview.R

//自定义的layoutTransition动画效果
class CustomLayoutTransitionActivity : AppCompatActivity() {

    private var index = 0
    private var container: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_transition)
        container = findViewById(R.id.container)

        //自定义的layoutTransition动画效果
        val layoutTransition = LayoutTransition()
        //入场动画
        layoutTransition.setAnimator(
            LayoutTransition.APPEARING,
            ObjectAnimator.ofFloat(null, "rotationY", 0f, 360f)
        )
        //出场动画
        layoutTransition.setAnimator(
            LayoutTransition.DISAPPEARING,
            ObjectAnimator.ofFloat(null, "rotation", 0f, 90f)
        )
        //不经常使用切会有各种问题
//        layoutTransition.setAnimator(
//            LayoutTransition.CHANGE_APPEARING,
//            ObjectAnimator.ofFloat(null, "scaleX", 1f, 2f, 1f)
//        )
//        layoutTransition.setAnimator(
//            LayoutTransition.CHANGE_DISAPPEARING,
//            ObjectAnimator.ofFloat(null, "scaleX", 1f, 0.5f, 1f)
//        )
        container?.layoutTransition = layoutTransition

        findViewById<Button>(R.id.btn_add).setOnClickListener {
            addButtonView()
        }
        findViewById<Button>(R.id.btn_remove).setOnClickListener {
            removeButtonView()
        }
    }

    private fun addButtonView() {
        index++
        Button(this).apply {
            text = "Button${index + 1}"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            container?.addView(this, 0)
        }
    }

    private fun removeButtonView() {
        if (index > 0) {
            container?.removeViewAt(0)
            index--
        }
    }

    companion object {
        const val TAG = "CustomLayoutTransitionActivity"
    }
}