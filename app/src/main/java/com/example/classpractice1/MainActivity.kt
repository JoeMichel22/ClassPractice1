package com.example.classpractice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread{
            repeat(100){
                Log.d("Countdown", (100 - it).toString())
            }
        }
    }
}