package com.byfrunze.motozip.content.search.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.byfrunze.motozip.R
import moxy.MvpAppCompatFragment


class ReviewFragment : MvpAppCompatFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_review, container, false)
    }
}
