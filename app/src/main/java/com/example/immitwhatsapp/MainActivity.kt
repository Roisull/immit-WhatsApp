package com.example.immitwhatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.immitwhatsapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPageAdapter: ViewPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPageAdapter = ViewPageAdapter(supportFragmentManager, lifecycle)

        with(binding){
            viewPager.adapter = viewPageAdapter

            TabLayoutMediator(tabLayout, viewPager){ tab, position ->
                when(position){
                    0 -> tab.text = "Chat"
                    1 -> tab.text = "Status"
                    2 -> tab.text = "Call"
                }
            }.attach()
        }
    }
}