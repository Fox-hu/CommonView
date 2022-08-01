package com.fox.commonview.recycleview.holder

import com.fox.commonview.R
import com.fox.commonview.databinding.ViewCellEmptyBinding
import com.fox.commonview.recycleview.pojo.EmptyPresenterModel

/**
 * @Author fox.hu
 * @Date 2020/5/18 13:56
 */
class EmptyBindingCell : DataBindingCell<EmptyPresenterModel, ViewCellEmptyBinding>() {

    override fun getLayoutResId(): Int = R.layout.view_cell_empty

    override fun bindData(vdb: ViewCellEmptyBinding?, item: EmptyPresenterModel, position: Int) {
        vdb?.apply {
            item.apply {
                ivEmpty.visibility = visibility
                tvEmpty.visibility = visibility
                tvEmpty.text = text
            }
        }
    }

    override fun bindView(vdb: ViewCellEmptyBinding) {
    }

}