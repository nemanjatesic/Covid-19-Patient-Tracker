package com.nemanja.prvidomaci.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.view.viewpager.PagerBottomAdapter
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity(R.layout.activity_bottom_navigation) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initViewPager()
        initNavigation()
    }

    private fun initViewPager() {
        viewPager.adapter = PagerBottomAdapter(supportFragmentManager)
    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_stanje ->  {
                    viewPager.setCurrentItem(PagerBottomAdapter.FRAGMENT_STANJE, false)
                }
                R.id.navigation_unos ->  {
                    viewPager.setCurrentItem(PagerBottomAdapter.FRAGMENT_UNOS, false)
                }
                R.id.navigation_liste ->  {
                    viewPager.setCurrentItem(PagerBottomAdapter.FRAGMENT_LISTE, false)
                }
                R.id.navigation_profil ->  {
                    viewPager.setCurrentItem(PagerBottomAdapter.FRAGMENT_PROFIL, false)
                }
            }
            true
        }
    }
}
