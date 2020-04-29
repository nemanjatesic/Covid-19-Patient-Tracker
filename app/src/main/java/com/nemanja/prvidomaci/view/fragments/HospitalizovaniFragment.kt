package com.nemanja.prvidomaci.view.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.model.PatientFactory
import com.nemanja.prvidomaci.view.activities.KartonActivity
import com.nemanja.prvidomaci.view.recycler.adapter.PatientAdapterHospitalizovani
import com.nemanja.prvidomaci.view.recycler.diff.PatientDiffItemCallback
import com.nemanja.prvidomaci.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_hospitalizovani.*
import timber.log.Timber
import java.util.*

class HospitalizovaniFragment : Fragment(R.layout.fragment_hospitalizovani) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var patientAdapterHospitalizovani: PatientAdapterHospitalizovani
    private var pritisnut = false

    companion object {
        const val MESSAGE_PATIENT = "PATIENT"
        const val MESSAGE_REQUEST_CODE = 1
    }

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
            if (pritisnut)
                sharedViewModel.filterPatients(it.toString(), SharedViewModel.HOSPITALIZOVANI)
        }
    }

    private val onKartonClicked: (Patient) -> Unit = {
        val intent = Intent(activity, KartonActivity::class.java)
        intent.putExtra(MESSAGE_PATIENT, it)
        startActivityForResult(intent, MESSAGE_REQUEST_CODE)
    }

    private val onOtpustClicked: (Patient) -> Unit = {
        val factory = PatientFactory()
        sharedViewModel.addPatient(factory.copyPatient(it, dateOfLeaving = Date()), SharedViewModel.OTPUSTENI)
        sharedViewModel.removePatient(it, SharedViewModel.HOSPITALIZOVANI)
        sharedViewModel.filterPatients(et_search_hospitalizovani.text.toString(), SharedViewModel.HOSPITALIZOVANI)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MESSAGE_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                data?.let { intent ->
                    val patient = intent.getParcelableExtra<Patient>(MESSAGE_PATIENT)
                    if (patient != null) {
                        val factory = PatientFactory()
                        sharedViewModel.let {
                            val patientTmp: Patient = it.getPatientById(patient.id, SharedViewModel.HOSPITALIZOVANI)?: factory.createPatient()
                            sharedViewModel.removePatient(patientTmp, SharedViewModel.HOSPITALIZOVANI)
                            sharedViewModel.addPatient(patient, SharedViewModel.HOSPITALIZOVANI)
                        }
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        pritisnut = false
        sharedViewModel.filterPatients("", SharedViewModel.HOSPITALIZOVANI)
    }

    override fun onResume() {
        super.onResume()
        pritisnut = true
        sharedViewModel.filterPatients(et_search_hospitalizovani.text.toString(), SharedViewModel.HOSPITALIZOVANI)
    }

}