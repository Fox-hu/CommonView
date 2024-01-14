package com.fox.commonview.animator

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.fox.commonview.R

//默认viewGroup的layoutTransition动画效果
class DefaultLayoutTransitionActivity : AppCompatActivity() {

    private var index = 0
    private var container: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_transition)
        container = findViewById(R.id.container)
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
        const val TAG = "DefaultLayoutTransitionActivity"
    }
}