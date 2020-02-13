package com.example.interviewcoding


interface Contract {
    interface PresenterContract {
        fun getPosts()
    }

    interface ViewContract {
        fun updateUI(posts: List<Post>)
    }
}