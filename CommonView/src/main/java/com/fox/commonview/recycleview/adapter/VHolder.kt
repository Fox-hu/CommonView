package com.fox.commonview.recycleview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author fox.hu
 * @Date 2020/5/14 13:58
 */
abstract class VHolder<T, VH : RecyclerView.ViewHolder> {

    abstract fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH

    abstract fun onBindViewHolder(holder: VH, item: T, position: Int)

    fun onBindViewHolder(holder: VH, item: T, position: Int, payload: List<Any>) {
        holder.itemView.tag = item
        onBindViewHolder(holder, item, position)
    }
}