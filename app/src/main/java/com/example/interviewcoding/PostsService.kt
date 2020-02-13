package com.example.interviewcoding

import io.reactivex.Observable
import retrofit2.http.GET

interface PostsService {
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}