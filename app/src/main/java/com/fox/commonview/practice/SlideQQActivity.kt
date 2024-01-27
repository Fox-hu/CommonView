package com.fox.commonview.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fox.commonview.R
import com.fox.commonview.custom.viewgroup.SlideMenuGroup

class SlideQQActivity : AppCompatActivity() {

    private var slideMenuGroup: SlideMenuGroup? = null
    private var mainViewTv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_qqactivity)

        val inflater = LayoutInflater.from(this)
        slideMenuGroup = findViewById(R.id.slide_menu_group)

        val mainView = inflater.inflate(R.layout.slide_content_layout, null, false)
        val mainLayoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        mainViewTv = mainView.findViewById(R.id.slide_main_view_text)

        val menuWidth = resources.getDimensionPixelOffset(R.dimen.slide_menu_width)
        val menuView = inflater.inflate(R.layout.slide_menu_layout, null, false)
        val menuLayoutParams = FrameLayout.LayoutParams(
            menuWidth,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        menuView.findViewById<TextView>(R.id.menu_apple).setOnClickListener {
            changeMainViewText("苹果")
        }
        menuView.findViewById<TextView>(R.id.menu_banana).setOnClickListener {
            changeMainViewText("香蕉")
        }
        menuView.findViewById<TextView>(R.id.menu_pear).setOnClickListener {
            changeMainViewText("大鸭梨")
        }
        slideMenuGroup?.setView(mainView, mainLayoutParams, menuView, menuLayoutParams)
    }

    private fun changeMainViewText(text: String) {
        mainViewTv?.text = text
        slideMenuGroup?.closeMenu()
    }
}