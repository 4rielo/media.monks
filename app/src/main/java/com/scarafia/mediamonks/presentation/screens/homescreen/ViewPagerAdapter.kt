package com.scarafia.mediamonks.presentation.screens.homescreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {

    var fragmentsList: List<Fragment> = emptyList()

    override fun getItemCount(): Int {
        return fragmentsList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentsList[position]
    }

    fun setFragmentList(fragmentList: List<Fragment>) {
        this.fragmentsList = fragmentList
        notifyDataSetChanged()
    }
}