package com.trinitydigital.spinneandrecyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SpinnerAdapter(context: Context, resource: Int, private val objects: List<CustomDataClass>) :
    ArrayAdapter<CustomDataClass>(context, resource, objects) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_spinner, parent, false)
        val tvTItle = view.findViewById<TextView>(R.id.tvTitle)

        tvTItle.text = objects[position].title
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dropdown, parent, false)
        val tvTItle = view.findViewById<TextView>(R.id.tvTitle)
        val tvID = view.findViewById<TextView>(R.id.tvID)

        tvTItle.text = objects[position].title
        tvID.text = objects[position].id.toString()

        return view
    }
}