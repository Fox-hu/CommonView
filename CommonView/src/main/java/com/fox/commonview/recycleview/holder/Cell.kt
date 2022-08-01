package com.fox.commonview.recycleview.holder

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.fox.commonview.recycleview.OnItemClickListener
import com.fox.commonview.recycleview.OnItemLongClickListener
import com.fox.commonview.recycleview.OnItemViewBindCallBack
import com.fox.commonview.recycleview.OnItemViewCreateCallBack

/**
 * @Author fox.hu
 * @Date 2020/5/14 15:44
 */
data class Cell<VDB : ViewDataBinding>(
    val layoutId: Int = 0,
    val presentModelId: Int = 0,
    val viewModelId: Int = 0,
    val viewModel: ViewModel? = null,
    val presentModelClass: Class<*>? = null,
    val bindCallBack: OnItemViewBindCallBack<VDB>? = null,
    val createCallBack: OnItemViewCreateCallBack<VDB>? = null,
    val clickCallBack: OnItemClickListener<VDB>? = null,
    val longClickCallBack: OnItemLongClickListener<VDB>? = null
)

