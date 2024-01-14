package com.fox.commonview.custom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.commonview.R
import com.fox.commonview.viewext.createTest
import kotlinx.android.synthetic.main.view_activity_vertical_drag.*

class VerticalDragActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_activity_vertical_drag)
        recyclerView.createTest(this)
    }
}
