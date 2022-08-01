package com.fox.commonview.stateslayout

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.fox.commonview.stateslayout.StateLayout
import com.fox.commonview.stateslayout.StateLayoutCallback

/**
 * 状态对应的数据集
 * 使用一个map存储状态，和状态对应的数据
 * key值为状态的Code值，value为一个StateParam对象
 */
class StateParam constructor(var stateLayout: StateLayout) {
    val drawableRes = ObservableInt()
    val text = ObservableField<String>()
    val buttonText = ObservableField<String>()
    var viewModel: StateLayoutCallback? = null
}