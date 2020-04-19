package com.byfrunze.motozip.content.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.byfrunze.motozip.R
import com.byfrunze.motozip.content.search.fragments.MotorcycleFragment
import com.byfrunze.motozip.content.search.fragments.ReviewFragment
import com.byfrunze.motozip.content.search.fragments.ZipFragment
import kotlinx.android.synthetic.main.fragment_search.*
import moxy.MvpAppCompatFragment


class SearchFragment : MvpAppCompatFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_search, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragments: ArrayList<MvpAppCompatFragment> = ArrayList()
        fragments.add(MotorcycleFragment())
        fragments.add(ZipFragment())
        fragments.add(ReviewFragment())

        fragment_container_search.replaceBy(MotorcycleFragment())

        bubble_nav.setNavigationChangeListener { _, position ->
            fragment_container_search.replaceBy(fragment = fragments[position])
        }

    }

    private fun FragmentContainerView.replaceBy(fragment: Fragment) = requireActivity().supportFragmentManager.beginTransaction().replace(id, fragment).commit()
}
