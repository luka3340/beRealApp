package com.example.berealapp.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.berealapp.fragments.ContentFragment
import com.example.berealapp.fragments.FeedFragment
import com.example.berealapp.fragments.ProfileFragment

class ViewPageAdapter(fragment: ContentFragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { FeedFragment() }
            1 -> { ProfileFragment() }
            else -> { FeedFragment() }
        }
    }
}