package com.example.offlinecacheretrohilt.features.UserAdapter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.offlinecacheretrohilt.databinding.ActivityMainBinding
import com.example.offlinecacheretrohilt.utils.Resourse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapters=UserAdapter()

        binding.apply {
            reccyler.setHasFixedSize(true)
            viewModel.restoram.observe(this@MainActivity, Observer {
                adapters.differ.submitList(it.data)
progressBar.isVisible= it is Resourse.Loadibg && it.data.isNullOrEmpty()
            })
        reccyler.adapter=adapters
            val deco=DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL)
            reccyler.addItemDecoration(deco)

        }




    }
}