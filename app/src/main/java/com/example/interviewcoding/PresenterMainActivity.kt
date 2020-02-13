package com.example.interviewcoding

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresenterMainActivity(private val contract : Contract.ViewContract): Contract.PresenterContract {

    override fun getPosts() {
        val retrofit = RetrofitClientInstance.getRetrofitInstance()

        retrofit?.let {retrofitInstance ->
            val postsService = retrofitInstance.create(PostsService::class.java)

            postsService.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    if (result != null) {
                        contract.updateUI(result)
                    }
                    else {
                        Log.e("TAG", "No results")
                    }
                }, {Log.e("TAG", it.message)})
        }
    }

}