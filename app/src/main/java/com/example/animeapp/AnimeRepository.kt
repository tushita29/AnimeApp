package com.example.animeapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.animeapp.models.Anime
import com.example.animeapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeRepository {
    private val animeList = MutableLiveData<List<Anime>>()

    fun getTopAnime(): LiveData<List<Anime>> {
        RetrofitClient.instance.getTopAnime().enqueue(object : Callback<com.example.animeapp.models.AnimeResponse> {
            override fun onResponse(call: Call<com.example.animeapp.models.AnimeResponse>, response: Response<com.example.animeapp.models.AnimeResponse>) {
                animeList.value = response.body()?.data ?: emptyList()
            }
            override fun onFailure(call: Call<com.example.animeapp.models.AnimeResponse>, t: Throwable) {
                animeList.value = emptyList()
            }
        })
        return animeList
    }
}
