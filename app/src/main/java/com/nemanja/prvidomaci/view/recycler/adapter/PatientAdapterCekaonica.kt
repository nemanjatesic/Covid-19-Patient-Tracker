package com.nemanja.prvidomaci.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.view.recycler.diff.PatientDiffItemCallbackCekaonica
import com.nemanja.prvidomaci.view.recycler.viewholder.PatientViewHolderCekaonica

class PatientAdapterCekaonica(
    patientDiffItemCallbackCekaonica: PatientDiffItemCallbackCekaonica,
    private val onPatientClicked: (Patient) -> Unit,
    private val onZdravClicked: (Patient) -> Unit,
    private val onHospitalizacijaClicked: (Patient) -> Unit) : ListAdapter<Patient, PatientViewHolderCekaonica>(patientDiffItemCallbackCekaonica) {

    private val functionPatient: (Int) -> Unit =  {
        if (it >= 0) {
            val patient = getItem(it)
            onPatientClicked.invoke(patient)
        }
    }

    private val functionZdrav: (Int) -> Unit =  {
        if (it >= 0) {
            val patient = getItem(it)
            onZdravClicked.invoke(patient)
        }
    }

    private val functionHospitalizacija: (Int) -> Unit =  {
        if (it >= 0) {
            val patient = getItem(it)
            onHospitalizacijaClicked.invoke(patient)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolderCekaonica {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_patient_list_item_cekaonica, parent, false)
        return PatientViewHolderCekaonica(containerView, functionPatient, functionZdrav, functionHospitalizacija)
    }

    override fun onBindViewHolder(holder: PatientViewHolderCekaonica, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }

}