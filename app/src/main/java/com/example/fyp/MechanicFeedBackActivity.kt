package com.example.fyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MechanicFeedBackActivity : AppCompatActivity() {
    lateinit var  searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanic_feed_back)
        searchView =  findViewById(R.id.searchView);
        val tvUserId = findViewById<TextView>(R.id.tvUserId)
        val tvUserName = findViewById<TextView>(R.id.tvUserName)
        val tvDate = findViewById<TextView>(R.id.tvDate)
        val tvFeedback = findViewById<TextView>(R.id.textView2)
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
}
}