package com.example.classpractice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val timerView: TextView by lazy{
        findViewById(R.id.tvTimer)
    }
    val countBTN: Button by lazy{
        findViewById(R.id.btnCount)
    }

    val scope= CoroutineScope(Job() + Dispatchers.Default)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countBTN.setOnClickListener {
            scope.launch {
                repeat(100) {
                    (100 - it).toString().run {
                        Log.d("Countdown", this)
                        withContext(Dispatchers.Main){
                             timerView.text= this@run
                        }
                    }
                    delay(500)
                }
            }
        }
    }
}