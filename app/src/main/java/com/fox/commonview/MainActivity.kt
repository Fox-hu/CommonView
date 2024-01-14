package com.fox.commonview

import com.fox.commonbase.base.BaseListActivity
import com.fox.commonview.animator.CustomLayoutTransitionActivity
import com.fox.commonview.animator.DefaultLayoutTransitionActivity
import com.fox.commonview.custom.ViewTestDemoSetActivity
import com.fox.commonview.custom.SimpleViewTestActivity
import com.fox.commonview.touch.TouchDemoActivity

class MainActivity : BaseListActivity() {
    override fun initItem() {
        activityMap["TouchDemo"] = TouchDemoActivity::class.java
        activityMap["LayoutTransition-Default"] = DefaultLayoutTransitionActivity::class.java
        activityMap["LayoutTransition-Custom"] = CustomLayoutTransitionActivity::class.java
        activityMap["SimpleTestView"] = SimpleViewTestActivity::class.java
        activityMap["ViewTestDemoSet"] = ViewTestDemoSetActivity::class.java

    }
}