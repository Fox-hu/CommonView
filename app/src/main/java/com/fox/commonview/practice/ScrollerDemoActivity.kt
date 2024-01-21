package com.fox.commonview.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.fox.commonview.R
import com.fox.commonview.custom.viewgroup.ScrollerLinearLayout

class ScrollerDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroller_demo)
        val scrollerLinearLayout = findViewById<ScrollerLinearLayout>(R.id.scroller_root)

        findViewById<Button>(R.id.btn_start).setOnClickListener {
            scrollerLinearLayout.startScroll(0, DISTANCE)
        }

        findViewById<Button>(R.id.btn_reset).setOnClickListener {
            scrollerLinearLayout.startScroll(DISTANCE, -DISTANCE)
        }

        findViewById<TextView>(R.id.tv_delete).setOnClickListener {
            Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show()
        }
    }

    companion object{
        private const val DISTANCE = 300
    }
}