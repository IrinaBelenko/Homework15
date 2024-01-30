package com.example.homework15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val requestButton: Button = findViewById(R.id.requestButton)
        val textContent: TextView = findViewById(R.id.content)
        requestButton.setOnClickListener {
                   textContent.text = ""
        val apiClient = ApiClient.client.create(ApiInterface::class.java)
       apiClient.getMeteo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
               textContent.text = "${it.timezone} ${it.elevation}"
           }, {
               Toast.makeText(this, "Request error", Toast.LENGTH_SHORT).show()
            })

        }
    }
}