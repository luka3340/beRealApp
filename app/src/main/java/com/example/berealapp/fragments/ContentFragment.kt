package com.example.berealapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.berealapp.R
import com.example.berealapp.adapters.ViewPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ContentFragment : Fragment(R.layout.fragment_content){
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_content, container,false)

        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewPager2)

        viewPager.adapter = ViewPageAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, i: Int ->
            when(i){
                0 -> tab.setIcon(R.drawable.ic_baseline_feed)
                1 -> tab.setIcon(R.drawable.ic_baseline_profile)
            }
        }.attach()

        return view
    }
}