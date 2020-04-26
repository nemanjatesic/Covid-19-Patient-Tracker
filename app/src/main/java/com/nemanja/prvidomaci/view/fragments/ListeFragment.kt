package com.nemanja.prvidomaci.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.view.viewpager.PagerTopAdapter
import kotlinx.android.synthetic.main.fragment_tabs.*

class ListeFragment : Fragment(R.layout.fragment_tabs) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initTabs()
    }

    private fun initTabs() {
        viewPagerTop.adapter = PagerTopAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(viewPagerTop)
    }

}
