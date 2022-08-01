package com.fox.commonview.stateslayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.fox.commonview.R
import com.fox.commonview.BR

/**
 * created by francis.fan on 2019/12/2
 */
class FrameImageLoadingLayout(private val mContext: Context) : StateLayout {
    private var mViewDataBinding: ViewDataBinding? = null

    override fun getStateView(): View {

        if (mViewDataBinding == null) {
            val inflater = LayoutInflater.from(mContext)
            mViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.view_common_loading_frame_image, null, false)
        }
        return mViewDataBinding!!.root
    }

    override fun bindData(stateParam: StateParam) {
        mViewDataBinding!!.setVariable(BR.presenterModel, stateParam)
    }
}
