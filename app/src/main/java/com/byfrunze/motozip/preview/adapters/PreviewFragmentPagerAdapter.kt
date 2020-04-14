package com.byfrunze.motozip.preview.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.byfrunze.motozip.preview.dataValues.backgroundColorArray
import com.byfrunze.motozip.preview.dataValues.resourceArray
import com.byfrunze.motozip.preview.dataValues.titleArray
import com.byfrunze.motozip.preview.fragments.PreviewSlideFragment

class PreviewFragmentPagerAdapter(fm: FragmentManager) :
        FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {



    override fun getItem(position: Int): Fragment {

        return PreviewSlideFragment.newInstance(
                backgroundColorArray[position],
                resourceArray[position],
                titleArray[position],
                position
        )
    }

    override fun getCount(): Int {
        return titleArray.count()
    }

}