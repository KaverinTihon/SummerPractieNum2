package com.itis.summerpractie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.itis.summerpractie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newBinding = ActivityMainBinding.inflate(layoutInflater)
        binding = newBinding
        setContentView(newBinding.root)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("ARG_COUNT")
        }

        binding.button.setOnClickListener {
            count++
            binding.tvHelloWorld.text = "Our counter: $count"
        }

        binding.etLogin.addTextChangedListener {
//            Log.e("etLogin", "Message: ${it?.toString()}")
            binding.tiLogin.error = null
        }
        binding.tiLogin.error = "ERROR"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ARG_COUNT", count)
    }
}