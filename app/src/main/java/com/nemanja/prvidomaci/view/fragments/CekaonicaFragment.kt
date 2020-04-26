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
import com.nemanja.prvidomaci.view.recycler.diff.PatientDiffItemCallback
import com.nemanja.prvidomaci.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.activity_classic_recycler.*

class CekaonicaFragment : Fragment(R.layout.fragment_cekaonica) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var patientAdapterCekaonica: PatientAdapterCekaonica

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
        et_search_cekaonica.doAfterTextChanged {
            sharedViewModel.filterPatients(it.toString(), SharedViewModel.CEKAONICA)
        }
    }

    private val clickOnZdrav: (Patient) -> Unit = {
        sharedViewModel.addPatient(it, SharedViewModel.OTPUSTENI)
        sharedViewModel.removePatient(it, SharedViewModel.CEKAONICA)
    }

    private val clickOnHospitalizacija: (Patient) -> Unit = {
        sharedViewModel.addPatient(it, SharedViewModel.HOSPITALIZOVANI)
        sharedViewModel.removePatient(it, SharedViewModel.CEKAONICA)
    }

    private fun initRecycler() {
        listRvCekaonica.layoutManager = LinearLayoutManager(activity)
        patientAdapterCekaonica = PatientAdapterCekaonica(PatientDiffItemCallback(), clickOnZdrav, clickOnHospitalizacija)
        listRvCekaonica.adapter = patientAdapterCekaonica
    }

    private fun initObservers() {
        sharedViewModel.getCekaonicaPacijenti().observe(viewLifecycleOwner, Observer {
            patientAdapterCekaonica.submitList(it)
        })
    }

}