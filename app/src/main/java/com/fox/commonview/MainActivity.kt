package com.fox.commonview

import com.fox.commonbase.base.BaseListActivity
import com.fox.commonview.touch.TouchDemoActivity

class MainActivity : BaseListActivity() {
    override fun initItem() {
          activityMap["TouchDemoActivity"] = TouchDemoActivity::class.java
    }
}