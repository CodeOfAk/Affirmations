package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialized data
        val myDataSet = Datasource().loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.rec_view)

        //For GRID LAYOUT
        GridLayoutManager(this, //context
            2, //span count
            RecyclerView.VERTICAL, //Orientation of recycler view
            false).apply {
            recyclerView.layoutManager = this
        }
        recyclerView.adapter = ItemAdapter(this, myDataSet)


        //Use this setting to improve performance if you know that changes
        //in context do not change the layout size of RecyclerView
        recyclerView.setHasFixedSize(true)


    }
}