package com.fox.commonview.custom

import com.fox.commonbase.base.BaseListActivity


class ViewTestDemoSetActivity : BaseListActivity() {

    override fun initItem() {
        activityMap["LockPatternActivity"] = LockPatternActivity::class.java
        activityMap["SlideActivity"] = SlideActivity::class.java
        activityMap["VerticalDragActivity"] = VerticalDragActivity::class.java
        activityMap["BubbleActivity"] = BubbleActivity::class.java
        activityMap["LoveActivity"] = LoveActivity::class.java
        activityMap["SplashActivity"] = SplashActivity::class.java
        activityMap["PaintCanvasActivity"] = PaintCanvasActivity::class.java
        activityMap["ShapeActivity"] = ShapeActivity::class.java
        activityMap["ScrollActivity"] = ScrollActivity::class.java
        activityMap["CoordinatorLayoutActivity"] = CoordinatorLayoutActivity::class.java
    }
}
