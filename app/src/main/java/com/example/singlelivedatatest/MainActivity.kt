package com.example.singlelivedatatest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.singlelivedatatest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.btnLiveData.setOnClickListener {
            viewModel.triggerLiveDataEvent()
        }

        binding.btnSingleLiveData.setOnClickListener {
            viewModel.triggerSingleLiveDataEvent()
        }

        viewModel.liveDataEvent.observe(this) {
            Toast.makeText(this, "LiveData 이벤트 발생", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SecondActivity::class.java))
        }

        viewModel.singleLiveDataEvent.observe(this) {
            Toast.makeText(this, "SingleLiveData 이벤트 발생", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}
