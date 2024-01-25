package com.fox.commonview.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.fox.commonview.R

class DragDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_demo)

        //如果在xml中设置了onClick事件
        //那么未重写getViewHorizontalDragRange、getViewVerticalDragRange的DragLayout将无法拖动子控件
        findViewById<TextView>(R.id.tv2).setOnClickListener {
            Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show()
        }
    }
}