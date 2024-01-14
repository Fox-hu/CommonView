package com.fox.commonview.custom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.commonview.custom.view.BubbleMessageTouchListener
import com.fox.commonview.custom.view.MessageBubbleView
import com.fox.commonview.R
import kotlinx.android.synthetic.main.view_activity_bubble.*

class BubbleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_activity_bubble)
        tv_test.setOnClickListener {

        }
        MessageBubbleView.attach(tv_test,
            object : BubbleMessageTouchListener.BubbleDisappearListener {
                override fun onDismiss() {

                }
            })
    }
}
