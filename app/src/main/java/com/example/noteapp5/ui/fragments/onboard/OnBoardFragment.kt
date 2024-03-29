package com.example.noteapp5.ui.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.noteapp5.R
import com.example.noteapp5.databinding.FragmentOnBoardBinding
import com.example.noteapp5.ui.adapter.OnBoardViewPagerAdapter
import com.example.noteapp5.ui.unitls.PreferenceHelper


class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(layoutInflater)
        preferenceHelper = PreferenceHelper()
        preferenceHelper.init(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setVisible()
        if (!preferenceHelper.isOnBoardShow) {
            preferenceHelper.isOnBoardShow = true
        }
    }

    private fun initialize() {
        binding.viewPager.adapter = OnBoardViewPagerAdapter(this)
    }

    private fun setupListener() = with(binding.viewPager) {
        binding.tvSkip.setOnClickListener {
            if (currentItem < 3) {
                setCurrentItem(currentItem + 2, true)
            }
        }
        binding.tvStartWork.setOnClickListener {
            if (binding.viewPager.currentItem == 2) {
                findNavController().navigate(R.id.noteFragment)

            }

        }
    }

    private fun setVisible() = with(binding) {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        tvSkip.isVisible = true
                        tvStartWork.isVisible = false
                    }

                    1 -> {
                        tvSkip.isVisible = true
                        tvStartWork.isVisible = false
                    }

                    2 -> {
                        tvSkip.isVisible = false
                        tvStartWork.isVisible = true
                    }
                }
                super.onPageSelected(position)
            }
        })

    }



}