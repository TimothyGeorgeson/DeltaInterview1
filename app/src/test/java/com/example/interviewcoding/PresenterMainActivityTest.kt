package com.example.interviewcoding

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.Observable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class PresenterMainActivityTest {
    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }
    @Mock
    private lateinit var contract: Contract.ViewContract
    @Mock
    private lateinit var postsService: PostsService

    private lateinit var presenter: PresenterMainActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PresenterMainActivity(contract, postsService)
    }

    @Test
    fun testGetPosts() {
        `when`(postsService.getPosts()).thenReturn(Observable.just(testResults()))

        presenter.getPosts()

        var actualResult = listOf<Post>()
        postsService.getPosts().subscribe { result ->
            actualResult = result
        }

        verify(contract).updateUI(ArgumentMatchers.anyList())
        assertEquals(actualResult, testResults())
    }

    private fun testResults(): List<Post> {
        return listOf(
            Post(1, 1, "title1", "body1"),
            Post(2, 2, "title2", "body2")
        )
    }
}