package com.example.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmretrofit.adapter.JokesAdapter
import com.example.mvvmretrofit.api.ApiInterface
import com.example.mvvmretrofit.api.ApiUtilities
import com.example.mvvmretrofit.databinding.ActivityMainBinding
import com.example.mvvmretrofit.model.Meme
import com.example.mvvmretrofit.repository.MemeRepository
import com.example.mvvmretrofit.viewmodel.MemesViewModel
import com.example.mvvmretrofit.viewmodel.MemesViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var jokesAdapter: JokesAdapter
    private lateinit var memesViewModel: MemesViewModel
    private lateinit var memesArrayList: ArrayList<Meme>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // get data api
        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val memeRepository = MemeRepository(apiInterface)
        memesViewModel = ViewModelProvider(this, MemesViewModelFactory(memeRepository)).get(MemesViewModel::class.java)

        // set to local variable
        memesArrayList = arrayListOf<Meme>()
        memesViewModel.memes.observe(this) {
            for (meme in it.data.memes) {
                memesArrayList.add(meme)
                Log.d("meme", "${memesArrayList.size}")
                if (memesArrayList.size == 10) break
            }
        }

        // recycler view
        binding.rvMemes.setHasFixedSize(true)
        binding.rvMemes.layoutManager = LinearLayoutManager(this)
        jokesAdapter = JokesAdapter(memesArrayList)
        binding.rvMemes.adapter = jokesAdapter

        // set content
        setContentView(binding.root)
    }
}