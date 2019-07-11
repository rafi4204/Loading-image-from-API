package com.example.loadingimagefromapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var dataList = ArrayList<model>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)

        //setting up the adapter
        recyclerView.adapter = MyAdapter(dataList, this)
        recyclerView.layoutManager = GridLayoutManager(this, 3) as RecyclerView.LayoutManager?

        val vmodel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        vmodel.loadUser()
        vmodel.users.observe(this, Observer { users ->
            dataList.addAll(users)
            recyclerView.adapter?.notifyDataSetChanged()
        })

    }


}
