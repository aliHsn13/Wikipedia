package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.PostItems
import com.example.wikipedia.databinding.ExploreItemBinding
import com.example.wikipedia.databinding.TrendItemBinding

class trendAdapter(private val data: ArrayList<PostItems>, val itemEvents: ItemEvents) :
    RecyclerView.Adapter<trendAdapter.TrendViewHolder>() {
    lateinit var binding: TrendItemBinding

    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(postItems: PostItems) {
            val glide = Glide
                .with(itemView.context)
                .load(postItems.img_url)
                .into(binding.imgTrendMain)

            binding.txtTrendTitle.text = postItems.txtTile
            binding.txtTrendSubtitle.text = postItems.txtSubtitle
            binding.txtTrendInsight.text = postItems.txtInsight
            binding.txtTrendNumber.text = ( adapterPosition + 1 ).toString()

            itemView.setOnClickListener {

                itemEvents.onItemClicked(postItems)

            }
            
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding = TrendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {

        holder.bindViews(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }
}