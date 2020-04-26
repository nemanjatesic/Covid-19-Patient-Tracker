package com.nemanja.prvidomaci.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.view.recycler.adapter.PatientAdapterCekaonica
import com.nemanja.prvidomaci.view.recycler.adapter.PatientAdapterHospitalizovani
import com.nemanja.prvidomaci.view.recycler.diff.PatientDiffItemCallback
import com.nemanja.prvidomaci.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.activity_classic_recycler.*
import kotlinx.android.synthetic.main.fragment_hospitalizovani.*

class HospitalizovaniFragment : Fragment(R.layout.fragment_hospitalizovani) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var patientAdapterHospitalizovani: PatientAdapterHospitalizovani

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
        et_search_hospitalizovani.doAfterTextChanged {
            sharedViewModel.filterPatients(it.toString(), SharedViewModel.HOSPITALIZOVANI)
        }
    }

    private val onKartonClicked: (Patient) -> Unit = {
//        sharedViewModel.addPatient(it, SharedViewModel.OTPUSTENI)
//        sharedViewModel.removePatient(it, SharedViewModel.CEKAONICA)
    }

    private val onOtpustClicked: (Patient) -> Unit = {
        sharedViewModel.addPatient(it, SharedViewModel.OTPUSTENI)
        sharedViewModel.removePatient(it, SharedViewModel.HOSPITALIZOVANI)
    }

    private fun initRecycler() {
        listRvHospitalizovani.layoutManager = LinearLayoutManager(activity)
        patientAdapterHospitalizovani = PatientAdapterHospitalizovani(PatientDiffItemCallback(), onKartonClicked, onOtpustClicked)
        listRvHospitalizovani.adapter = patientAdapterHospitalizovani
    }

    private fun initObservers() {
        sharedViewModel.getHospitalizovaniPacijenti().observe(viewLifecycleOwner, Observer {
            patientAdapterHospitalizovani.submitList(it)
        })
    }

}