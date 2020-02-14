package com.example.interviewcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.ViewContract {

    private val presenter by lazy{PresenterMainActivity(this, getPostsService())}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getPosts()
    }

    override fun updateUI(posts: List<Post>) {
        rvPosts.layoutManager = LinearLayoutManager(this)
        rvPosts.adapter = MainActivityAdapter(posts)
    }

    private fun getPostsService(): PostsService {
        val retrofit = RetrofitClientInstance.getRetrofitInstance()
        return retrofit!!.create(PostsService::class.java)
    }
}
