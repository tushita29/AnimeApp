package com.example.animeapp.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.animeapp.R
import com.example.animeapp.models.Anime
import com.squareup.picasso.Picasso

class AnimeAdapter(private val animeList: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.animeTitle)
        val episodes: TextView = view.findViewById(R.id.animeEpisodes)
        val rating: TextView = view.findViewById(R.id.animeRating)
        val image: ImageView = view.findViewById(R.id.animeImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animeList[position]
        holder.title.text = anime.title
        holder.episodes.text = "Episodes: ${anime.episodes ?: "N/A"}"
        holder.rating.text = "Rating: ${anime.score ?: "N/A"}"
        Picasso.get().load(anime.images.jpg.image_url).into(holder.image)
    }

    override fun getItemCount() = animeList.size
}
