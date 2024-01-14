package com.fox.commonview.custom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fox.commonview.R
import kotlinx.android.synthetic.main.view_activity_love.*

class LoveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_activity_love)
    }

    fun addLove(view: View) {
        love_layout.addLove()
    }
}
