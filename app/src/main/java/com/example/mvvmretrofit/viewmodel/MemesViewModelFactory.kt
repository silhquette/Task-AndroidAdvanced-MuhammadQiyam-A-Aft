package com.example.mvvmretrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofit.repository.MemeRepository

class MemesViewModelFactory(private val memeRepository: MemeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemesViewModel(memeRepository) as T
    }
}