package com.example.interviewcoding

import io.reactivex.Observable
import org.junit.Test
import org.mockito.Mockito
import org.junit.Assert.*
import org.mockito.Mockito.`when`


class PresenterMainActivityTest {

    @Test
    fun testGetPosts() {
        val postsService = Mockito.mock(PostsService::class.java)
        `when`(postsService.getPosts()).thenReturn(Observable.just(testResults()))

        var actualResult = listOf<Post>()
        postsService.getPosts().subscribe { result ->
            actualResult = result
        }

        assertEquals(actualResult, testResults())
    }

    private fun testResults(): List<Post> {
        return listOf(
            Post(1, 1, "title1", "body1"),
            Post(2, 2, "title2", "body2")
        )
    }
}