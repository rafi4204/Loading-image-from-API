package com.example.loadingimagefromapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var dataList = ArrayList<model>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)

        //setting up the adapter
        recyclerView.adapter= MyAdapter(dataList,this)
        recyclerView.layoutManager=GridLayoutManager(this,3)

     getData()

    }

    private fun getData(){

        val call: Call<List<model>> = APIclient.getClient.getInfo()
        call.enqueue(object : Callback<List<model>> {

            override fun onResponse(call: Call<List<model>>?, response: Response<List<model>>?) {
              //  progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
                Log.d("1",dataList[1].name)
            }

            override fun onFailure(call: Call<List<model>>?, t: Throwable?) {
               // progerssProgressDialog.dismiss()
            }

        })
    }
}
