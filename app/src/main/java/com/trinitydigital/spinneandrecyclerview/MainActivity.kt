package com.trinitydigital.spinneandrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var spiner: Spinner? = null
    private var recyclerView: RecyclerView? = null
    private val adapterRV = GridAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupAdapters()
        setupListeners()
    }

    private fun setupView() {
        spiner = findViewById(R.id.spinner)
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun setupListeners() {
        spiner?.onItemSelectedListener = this
    }


    private fun setupAdapters() {
        val adapter = SpinnerAdapter(applicationContext, R.id.tvTitle, getDataForSpinner())
        spiner?.adapter = adapter



        recyclerView?.layoutManager =
            GridLayoutManager(applicationContext, 2, RecyclerView.VERTICAL, false)

        recyclerView?.adapter = adapterRV

    }

    private fun getDataForSpinner(): ArrayList<CustomDataClass> {
        val data = arrayListOf<CustomDataClass>()

        data.add(CustomDataClass(10, "10 элементов recycler"))
        data.add(CustomDataClass(100, "100 элементов recycler"))
        data.add(CustomDataClass(500, "500 элементов recycler"))
        data.add(CustomDataClass(1000, "1000 элементов recycler"))

        return data
    }

    private fun getDataForRecyclerView(count: Int): ArrayList<CustomDataClass> {
        val data = arrayListOf<CustomDataClass>()

        for (i in 1..count) {
            data.add(CustomDataClass(i, "data $i"))
        }

        return data
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = (parent?.getItemAtPosition(position) as CustomDataClass)
        adapterRV.update(getDataForRecyclerView(item.id))
    }
}