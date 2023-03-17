package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.PostItems
import com.example.wikipedia.databinding.ExploreItemBinding

class exploreAdapter(private val data: ArrayList<PostItems>, val itemEvents: ItemEvents) :
    RecyclerView.Adapter<exploreAdapter.ExploreViewHolder>() {
    lateinit var binding: ExploreItemBinding

    inner class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(postItems: PostItems) {
            val glide = Glide
                .with(itemView.context)
                .load(postItems.img_url)
                .into(binding.imgExploreMain)

            binding.txtExploreTitle.text = postItems.txtTile
            binding.txtExploreSubtitle.text = postItems.txtSubtitle
            binding.txtExploreDetail.text = postItems.txtDetails

            itemView.setOnClickListener {

                itemEvents.onItemClicked( postItems )

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ExploreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploreViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {

        holder.bindViews(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }
}