package com.example.calklove.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calklove.databinding.ActivityOnBoardingBinding
import com.example.calklove.onboarding.adapter.OnBoardingAdapter

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private val pages = listOf(
        OnBoardingPage("Have a good time", "You should take the time to help those who need you", "animation1.json"),
        OnBoardingPage("Cherishing love", "It is now no longer possible for you to cherish love", "animation2.json"),
        OnBoardingPage("Have a breakup?", "We have made the correction for you don't worry  Maybe someone is waiting for you", "animation3.json"),
        OnBoardingPage("Start now", "good time and love!", "animation4.json")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = OnBoardingAdapter(pages)
        binding.viewpager.adapter = adapter
        binding.indicator.setViewPager(binding.viewpager)
    }
}
