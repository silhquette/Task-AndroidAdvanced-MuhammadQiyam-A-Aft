package com.example.mvvmretrofit.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofit.api.ApiInterface
import com.example.mvvmretrofit.model.Jokes

class MemeRepository(private val apiInterface: ApiInterface) {
    private val memesLiveData = MutableLiveData<Jokes>()

    val memes: LiveData<Jokes>
        get() = memesLiveData

    suspend fun getMemes() {
        val result = apiInterface.getJokes()
        if (result.body() != null) {
            memesLiveData.postValue(result.body())
        }
//        Log.d("result", "getNews: ${result}")
//        Log.d("body", "getNews: ${result.body()}")
    }
}