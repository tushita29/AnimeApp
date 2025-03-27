package com.example.animeapp.network

import com.example.animeapp.models.AnimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {
    @GET("top/anime")
    fun getTopAnime(): Call<AnimeResponse>

    @GET("anime/{anime_id}")
    fun getAnimeDetails(@Path("anime_id") animeId: Int): Call<AnimeResponse>
}
