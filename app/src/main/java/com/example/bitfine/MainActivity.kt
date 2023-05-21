package com.example.bitfine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btn_Add : Button
    private lateinit var btn_Read : Button
    private lateinit var btn_Update : Button
    private lateinit var btn_Delete : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Add = findViewById(R.id.btn_Add)
        btn_Read = findViewById(R.id.btn_Read)
        btn_Update = findViewById(R.id.btn_Update)
        btn_Delete = findViewById(R.id.btn_Delete)

        btn_Add.setOnClickListener {
            var intent = Intent(this@MainActivity,activity_add::class.java)
            startActivity(intent)
        }

        btn_Read.setOnClickListener {
            var intent = Intent(this@MainActivity,activity_read::class.java)
            startActivity(intent)
        }

        btn_Update.setOnClickListener {
            var intent = Intent(this@MainActivity,activity_update::class.java)
            startActivity(intent)
        }

        btn_Delete.setOnClickListener {
            var intent = Intent(this@MainActivity,activity_delete::class.java)
            startActivity(intent)
        }


    }
}