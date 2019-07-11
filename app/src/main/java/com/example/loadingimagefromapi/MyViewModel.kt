package com.example.loadingimagefromapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel : ViewModel() {

    var users = MutableLiveData<List<model>>()

    fun loadUser() {

        val call: Call<List<model>> = APIclient.getClient.getInfo()
        call.enqueue(object : Callback<List<model>> {

            override fun onResponse(call: Call<List<model>>, response: Response<List<model>>) {


                users.value = response.body()


            }

            override fun onFailure(call: Call<List<model>>?, t: Throwable?) {
                // progerssProgressDialog.dismiss()
            }

        })
    }


}