package com.example.berealapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

//class PostRecyclerAdapter(private val posts: List<PostItemData>): RecyclerView.Adapter<PostRecyclerAdapter.PostViewHolder>() {
//    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
//
//        fun setData(post: PostItemData) {
//                    Glide.with(itemView)
//                        .load(post.imageUrl)
//                        .into(imageView)
//                }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
//        return PostViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//        holder.setData(posts[position])
//    }
//
//
//    override fun getItemCount() = posts.size
//}