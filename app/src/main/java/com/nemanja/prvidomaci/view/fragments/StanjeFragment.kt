package com.nemanja.prvidomaci.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_stanje.*

class StanjeFragment : Fragment(R.layout.fragment_stanje) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {
        sharedViewModel.getCekaonicaPacijenti().observe(viewLifecycleOwner, Observer {
            brojPacijenataCekaonicaBrojTV.text = it.size.toString()
        })
        sharedViewModel.getHospitalizovaniPacijenti().observe(viewLifecycleOwner, Observer {
            brojHospitalizovanihPacijenataBrojTV.text = it.size.toString()
        })
        sharedViewModel.getOtpusteniPacijenti().observe(viewLifecycleOwner, Observer {
            brojOtpustenihPacijenataBrojTV.text = it.size.toString()
        })
    }

}