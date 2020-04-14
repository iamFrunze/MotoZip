package com.byfrunze.motozip.preview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.byfrunze.motozip.R
import com.byfrunze.motozip.preview.adapters.PreviewFragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        PreviewSwipeViewPager.adapter = PreviewFragmentPagerAdapter(supportFragmentManager)
        PreviewSwipeViewPager.setCurrentItem(0, false)
        pageIndicatorView.count = 5
        pageIndicatorView.selection = 0
        PreviewSwipeViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                pageIndicatorView.selection = position
            }

            override fun onPageSelected(position: Int) {
            }

        })

    }
}