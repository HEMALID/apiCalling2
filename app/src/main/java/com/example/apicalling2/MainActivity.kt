package com.example.apicalling2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apicalling2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quotesApi = RetrofitHelper.getInstance()
            .create(QuotesApi::class.java)


        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            if (result != null){
                    GlobalScope.launch(Dispatchers.Main) {
                        binding.txt.text = result.toString()

                }
            }
        }
    }
}