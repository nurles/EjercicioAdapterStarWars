package com.cbellmont.ejercicioadapterstarwars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter : FilmsAdapter = FilmsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createRecyclerView()
    }

    private fun createRecyclerView() {
        film_recycler_view.layoutManager = LinearLayoutManager(this)
        film_recycler_view.adapter = adapter
    }
}