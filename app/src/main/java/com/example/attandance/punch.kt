package com.example.attandance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.attandance.databinding.ActivityMainBinding
import com.example.attandance.databinding.ActivityPunchBinding

class punch : AppCompatActivity() {
    private lateinit var binding: ActivityPunchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPunchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.punchin.setOnClickListener {
            val Intent = Intent(this,MapsActivity::class.java)
            startActivity(Intent)
        }
    }
}