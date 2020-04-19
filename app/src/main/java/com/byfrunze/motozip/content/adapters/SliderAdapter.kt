package com.byfrunze.motozip.content.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import moxy.MvpAppCompatFragment

class SliderAdapter(private val fm: FragmentManager,
                    private val fragmentList: ArrayList<MvpAppCompatFragment> = ArrayList()
) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }



    override fun getCount() =
            fragmentList.size
}
