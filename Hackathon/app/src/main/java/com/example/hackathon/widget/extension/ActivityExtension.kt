package com.example.hackathon.widget.extension

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.startActivity(activity: Class<*>) {
    val intent = Intent(this, activity)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    startActivity(intent)
    finish()
}

fun AppCompatActivity.noFinishStartActivity(activity: Class<*>) {
    val intent = Intent(this, activity)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    startActivity(intent)
}

fun AppCompatActivity.toast(text : String) {
    android.widget.Toast.makeText(applicationContext, text, android.widget.Toast.LENGTH_SHORT).show()
}
