package com.example.loadingimagefromapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter (private var dataList: List<model>, private val context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_home, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel=dataList.get(position)
        //Glide.with(itemView.context).load(movieModel.moviePicture!!).into(itemView.imageMovie)
        Glide.with(holder.image.getContext())
            .load(dataModel.url?.large)
            .into(holder.image);
        holder.titleTextView.text=dataModel.name
        holder.time.text=dataModel.timestamp

    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        lateinit var titleTextView: TextView
        lateinit var time: TextView
        lateinit var image: ImageView
        init {
            titleTextView=itemLayoutView.findViewById(R.id.name)
            image=itemLayoutView.findViewById(R.id.image)
            time=itemLayoutView.findViewById(R.id.timestamp)

        }

    }
}