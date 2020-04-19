package com.byfrunze.motozip.content.search.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.byfrunze.motozip.R
import com.byfrunze.motozip.content.search.models.TopFeedModel
import com.squareup.picasso.Picasso

class TopFeedAdapter : RecyclerView.Adapter<TopFeedAdapter.ViewHolder>() {

    private val listFeed: ArrayList<TopFeedModel> = ArrayList()
    fun setup(list: ArrayList<TopFeedModel>) {
        listFeed.clear()
        listFeed.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_top_feed_motorcycle, parent, false))
    }

    override fun getItemCount() = listFeed.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(listFeed[position])
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imgFeed: ImageView = itemView.findViewById(R.id.img_top_feed_motorcycle)
        private val txtFeed: TextView = itemView.findViewById(R.id.txt_top_feed_motorcycle)

        fun bind(model: TopFeedModel) {
            Picasso.get()
                    .load(model.img)
                    .placeholder(R.drawable.ic_motorcycle)
                    .into(imgFeed)
            txtFeed.text = model.txt
        }
    }
}