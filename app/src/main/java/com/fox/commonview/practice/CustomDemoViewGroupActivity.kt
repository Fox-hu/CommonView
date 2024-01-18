package com.fox.commonview.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.commonview.R

/**
 *  一个最简单的继承自ViewGroup的自定义View
 *  示范了自定义ViewGroup必须要做的步骤
 */
class CustomDemoViewGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_demo_view_group)
    }
}