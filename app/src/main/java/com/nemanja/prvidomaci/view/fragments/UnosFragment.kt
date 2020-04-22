package com.nemanja.prvidomaci.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.model.PatientFactory
import com.nemanja.prvidomaci.view.activities.LoginActivity
import com.nemanja.prvidomaci.viewmodel.DodajViewModel
import com.nemanja.prvidomaci.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_unos.*
import java.text.SimpleDateFormat
import java.util.*

class UnosFragment : Fragment(R.layout.fragment_unos) {

    private val showViewModel: DodajViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        button_dodaj_u_ceokaonicu.setOnClickListener {
            val patientName = et_user_name_unos
            val patientLastName = et_user_lastname_unos
            val patientSymptoms = et_user_hospital_unos

            if (patientName == null || patientLastName == null || patientSymptoms == null) {
                Toast.makeText(activity?.applicationContext,"Unesite makar nesto u svako polje", Toast.LENGTH_SHORT).show()
            }

            if (checkText(patientName,"Unesite ime pacijenta") &&
                checkText(patientLastName,"Unesite prezime pacijenta") &&
                checkText(patientSymptoms,"Unesite simptome pacijenta")) {
                val date: Date = Date()
                val sdf: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
                val dateString: String = sdf.format(date)
                val sharedPreferences = activity?.getSharedPreferences(activity?.packageName, Context.MODE_PRIVATE)
                val hospital = sharedPreferences?.getString(LoginActivity.USER_HOSPITAL, "Unknown")
                val patient: Patient = PatientFactory().createPatient(name = patientName.text.toString(),
                        lastName = patientLastName.text.toString(), stateOnReception = patientSymptoms.text.toString(), dateOfArrival = dateString, hospital = hospital)
                sharedViewModel.addPatientToCekaonica(patient)
                Toast.makeText(activity?.applicationContext,"Pacijent dodat!", Toast.LENGTH_SHORT).show()
                patientName?.setText("")
                patientLastName?.setText("")
                patientSymptoms?.setText("")
            }
        }
    }

    private fun checkText(text: EditText, textOut: String): Boolean {
        if (text.text.isEmpty()) {
            Toast.makeText(activity?.applicationContext,textOut,Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}