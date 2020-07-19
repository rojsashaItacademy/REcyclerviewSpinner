package com.trinitydigital.spinneandrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_grid.view.*

class GridAdapter() :
    RecyclerView.Adapter<GridAdapter.GridVH>() {

    private var list = arrayListOf<CustomDataClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return GridVH(view)
    }

    fun update(data: ArrayList<CustomDataClass>) {
        list = data
        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: GridVH, position: Int) {
        holder.bind(list[position])
    }


    class GridVH(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(customDataClass: CustomDataClass) {
            itemView.tvTitleOne.text = customDataClass.title
        }

    }
}