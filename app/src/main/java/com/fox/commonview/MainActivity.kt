package com.fox.commonview

import com.fox.commonbase.base.BaseListActivity
import com.fox.commonview.animator.ViewGroupTransitionActivity
import com.fox.commonview.custom.ViewTestDemoSetActivity
import com.fox.commonview.custom.SimpleViewTestActivity
import com.fox.commonview.practice.PracticeListActivity
import com.fox.commonview.touch.TouchDemoActivity

class MainActivity : BaseListActivity() {
    override fun initItem() {
        activityMap["TouchDemo"] = TouchDemoActivity::class.java
        activityMap["ViewGroupTransitionActivity"] = ViewGroupTransitionActivity::class.java
        activityMap["SimpleTestView"] = SimpleViewTestActivity::class.java
        activityMap["ViewTestDemoSet"] = ViewTestDemoSetActivity::class.java
        activityMap["PracticeListActivity"] = PracticeListActivity::class.java
    }
}