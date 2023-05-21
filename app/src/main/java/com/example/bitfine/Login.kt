package com.example.bitfine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bitfine.databinding.ActivityMainBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}