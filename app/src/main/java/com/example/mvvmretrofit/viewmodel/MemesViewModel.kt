package com.example.mvvmretrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofit.model.Jokes
import com.example.mvvmretrofit.repository.MemeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesViewModel(private val memeRepository: MemeRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            memeRepository.getMemes()
        }
    }

    val memes: LiveData<Jokes>
        get() = memeRepository.memes
}