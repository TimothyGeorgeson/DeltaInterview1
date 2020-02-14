package com.example.interviewcoding

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresenterMainActivity(private val contract : Contract.ViewContract, private val postsService: PostsService): Contract.PresenterContract {

    @SuppressLint("CheckResult")
    override fun getPosts() {
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
