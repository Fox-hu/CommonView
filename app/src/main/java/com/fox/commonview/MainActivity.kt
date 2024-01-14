package com.fox.commonview

import com.fox.commonbase.base.BaseListActivity
import com.fox.commonview.animator.CustomLayoutTransitionActivity
import com.fox.commonview.animator.DefaultLayoutTransitionActivity
import com.fox.commonview.touch.TouchDemoActivity

class MainActivity : BaseListActivity() {
    override fun initItem() {
        activityMap["TouchDemoActivity"] = TouchDemoActivity::class.java
        activityMap["DefaultLayoutTransitionActivity"] = DefaultLayoutTransitionActivity::class.java
        activityMap["CustomLayoutTransitionActivity"] = CustomLayoutTransitionActivity::class.java
    }
}