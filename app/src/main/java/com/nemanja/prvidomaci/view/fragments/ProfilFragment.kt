package com.nemanja.prvidomaci.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nemanja.prvidomaci.R

class ProfilFragment : Fragment(R.layout.fragment_profil) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {

    }
}