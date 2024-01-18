package com.fox.commonview.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.commonview.R

/**
 * 一个最简单的继承自view的示例
 * 示范了自定义view必须要做的步骤
 */
class WrapContentCustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wrap_content_custom_view)
    }
}