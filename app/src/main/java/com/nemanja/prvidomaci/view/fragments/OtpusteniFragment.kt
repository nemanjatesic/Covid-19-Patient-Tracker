package com.nemanja.prvidomaci.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.view.recycler.adapter.PatientAdapterHospitalizovani
import com.nemanja.prvidomaci.view.recycler.adapter.PatientAdapterOtpusteni
import com.nemanja.prvidomaci.view.recycler.diff.PatientDiffItemCallback
import com.nemanja.prvidomaci.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_otpusteni.*
import timber.log.Timber

class OtpusteniFragment : Fragment(R.layout.fragment_otpusteni) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var patientAdapterOtpusteni: PatientAdapterOtpusteni
    private var pritisnut = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
    }

    private fun initUi() {
        initObservers()
        initListeners()
        initRecycler()
    }

    private fun initListeners() {
        et_search_otpusteni.doAfterTextChanged {
            if (pritisnut)
                sharedViewModel.filterPatients(it.toString(), SharedViewModel.OTPUSTENI)
        }
    }

    private fun initRecycler() {
        listRvOtpusteni.layoutManager = GridLayoutManager(activity, 2)
        patientAdapterOtpusteni = PatientAdapterOtpusteni(PatientDiffItemCallback())
        listRvOtpusteni.adapter = patientAdapterOtpusteni
    }

    private fun initObservers() {
        sharedViewModel.getOtpusteniPacijenti().observe(viewLifecycleOwner, Observer {
            patientAdapterOtpusteni.submitList(it)
        })
    }

    override fun onPause() {
        super.onPause()
        pritisnut = false
        sharedViewModel.filterPatients("", SharedViewModel.OTPUSTENI)
    }

    override fun onResume() {
        super.onResume()
        pritisnut = true
        sharedViewModel.filterPatients(et_search_otpusteni.text.toString(), SharedViewModel.OTPUSTENI)
    }
}