package com.fox.commonview.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.commonbase.base.BaseListActivity
import com.fox.commonview.R
import com.fox.commonview.animator.ViewGroupTransitionActivity
import com.fox.commonview.custom.SimpleViewTestActivity
import com.fox.commonview.custom.ViewTestDemoSetActivity
import com.fox.commonview.touch.TouchDemoActivity

class PracticeListActivity : BaseListActivity() {
    override fun initItem() {
        activityMap["WrapContentCustomView"] = WrapContentCustomViewActivity::class.java
        activityMap["VerticalViewGroup"] = CustomDemoViewGroupActivity::class.java
        activityMap["DirectionDemo"] = DirectionDemoActivity::class.java
        activityMap["ScrollerDemo"] = ScrollerDemoActivity::class.java
        activityMap["DragHelperDemo"] = DragDemoActivity::class.java
    }
}