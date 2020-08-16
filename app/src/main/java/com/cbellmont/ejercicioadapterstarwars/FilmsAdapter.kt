package com.cbellmont.ejercicioadapterstarwars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FilmsAdapter() : RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    class Film(var id : Int, var name : String, var intro : String) {
        fun getUrlImage() : String {
            return when (id) {
                1 -> "https://upload.wikimedia.org/wikipedia/en/4/40/Star_Wars_Phantom_Menace_poster.jpg"
                2 -> "https://upload.wikimedia.org/wikipedia/en/3/32/Star_Wars_-_Episode_II_Attack_of_the_Clones_%28movie_poster%29.jpg"
                3 -> "https://upload.wikimedia.org/wikipedia/en/9/93/Star_Wars_Episode_III_Revenge_of_the_Sith_poster.jpg"
                4 -> "https://upload.wikimedia.org/wikipedia/en/8/87/StarWarsMoviePoster1977.jpg"
                5 -> "https://upload.wikimedia.org/wikipedia/en/3/3c/SW_-_Empire_Strikes_Back.jpg"
                6 -> "https://upload.wikimedia.org/wikipedia/en/b/b2/ReturnOfTheJediPoster1983.jpg"
                else -> "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/George_Lucas.jpg/330px-George_Lucas.jpg"
            }
        }
    }
    var films : List<Film> = listOf(
        Film(1, "La Amenaza Fantasma", "aaaa"),
        Film(2, "El Ataque de los Clones", "aaaa"),
        Film(3, "La Venganza de los Sith", "aaaa"),
        Film(4, "Una Nueva Esperanza", "aaaa"),
        Film(5, "El Imperio Contraataca", "aaaa"),
        Film(6, "El Retorno del Jedi", "aaaa")
        )

    class FilmsViewHolder(root: View, var tvNombre: TextView, var tvIntro: TextView, var ivDerecha: ImageView, var ivIzquierda: ImageView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_layout, parent, false)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvIntro = view.findViewById<TextView>(R.id.tvIntro)
        val ivDerecha = view.findViewById<ImageView>(R.id.ivDerecha)
        val ivIzquierda = view.findViewById<ImageView>(R.id.ivIzquierda)

        return FilmsViewHolder(view, tvName, tvIntro, ivDerecha, ivIzquierda)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.tvIntro.text = films[position].intro
        holder.tvNombre.text = films[position].name
        if (position > 2){
            holder.ivIzquierda.visibility = View.GONE
            holder.ivDerecha.visibility = View.VISIBLE
            Picasso.get().load(films[position].getUrlImage()).into(holder.ivDerecha)
        }  else {
            holder.ivIzquierda.visibility = View.VISIBLE
            holder.ivDerecha.visibility = View.GONE
            Picasso.get().load(films[position].getUrlImage()).into(holder.ivIzquierda)
        }
    }
}
