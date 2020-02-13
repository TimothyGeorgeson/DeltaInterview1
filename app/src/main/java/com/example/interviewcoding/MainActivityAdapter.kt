package com.example.interviewcoding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class MainActivityAdapter(val posts: List<Post>): RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = posts[position].userId.toString()
        holder.id.text = posts[position].id.toString()
        holder.title.text = posts[position].title
        holder.body.text = posts[position].body
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val userId: TextView = view.userId
        val id: TextView = view.tvId
        val title: TextView = view.title
        val body: TextView = view.body
    }
}