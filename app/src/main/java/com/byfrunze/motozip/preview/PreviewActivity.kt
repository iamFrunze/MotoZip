package com.byfrunze.motozip.preview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.byfrunze.motozip.R
import com.byfrunze.motozip.preview.adapters.PreviewFragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        PreviewSwipeViewPager.adapter = PreviewFragmentPagerAdapter(supportFragmentManager)
        PreviewSwipeViewPager.setCurrentItem(0, false)
        Log.i("ITEM", "${PreviewSwipeViewPager.currentItem}")

    }
}