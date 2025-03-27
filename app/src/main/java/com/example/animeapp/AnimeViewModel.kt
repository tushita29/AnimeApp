package com.example.animeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.animeapp.models.Anime
import com.example.animeapp.repository.AnimeRepository

class AnimeViewModel : ViewModel() {
    private val repository = AnimeRepository()

    fun getAnimeList(): LiveData<List<Anime>> {
        return repository.getTopAnime()
    }
}
