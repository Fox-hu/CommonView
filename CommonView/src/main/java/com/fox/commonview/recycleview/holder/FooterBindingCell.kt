package com.fox.commonview.recycleview.holder

import com.fox.commonview.R
import com.fox.commonview.databinding.ViewCellLoadingMoreBinding
import com.fox.commonview.recycleview.pojo.FooterPresenterModel

/**
 * @Author fox.hu
 * @Date 2020/5/18 13:56
 */
class FooterBindingCell : DataBindingCell<FooterPresenterModel, ViewCellLoadingMoreBinding>() {

    override fun getLayoutResId(): Int = R.layout.view_cell_loading_more

    override fun bindData(
        vdb: ViewCellLoadingMoreBinding?,
        item: FooterPresenterModel,
        position: Int
    ) {
        vdb?.apply {
            footer = item
        }
    }

    override fun bindView(vdb: ViewCellLoadingMoreBinding) {

    }

}