package com.fox.commonview.recycleview.datasource

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 * @Author fox.hu
 * @Date 2020/5/15 13:46
 */
interface DataLoader {

    var list: PagedList<Any>

    fun fetchData(pageAt: Int, pageSize: Int): LiveData<List<Any>>
}