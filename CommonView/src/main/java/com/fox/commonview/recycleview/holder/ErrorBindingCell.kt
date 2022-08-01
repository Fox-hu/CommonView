package com.fox.commonview.recycleview.holder

import com.fox.commonview.R
import com.fox.commonview.databinding.ViewCellErrorBinding
import com.fox.commonview.recycleview.pojo.ErrorPresenterModel

/**
 * @Author fox.hu
 * @Date 2020/5/18 13:56
 */
class ErrorBindingCell : DataBindingCell<ErrorPresenterModel, ViewCellErrorBinding>() {

    override fun getLayoutResId(): Int = R.layout.view_cell_error

    override fun bindData(vdb: ViewCellErrorBinding?, item: ErrorPresenterModel, position: Int) {
        vdb?.apply {
            item.apply {
                ivError.visibility = visibility
                tvError.visibility = visibility
                tvError.text = text
            }
        }
    }

    override fun bindView(vdb: ViewCellErrorBinding) {
    }

}