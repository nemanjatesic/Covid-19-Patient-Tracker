package com.nemanja.prvidomaci.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.view.recycler.diff.PatientDiffItemCallback
import com.nemanja.prvidomaci.view.recycler.viewholder.PatientViewHolder

class PatientAdapter(
    patientDiffItemCallback: PatientDiffItemCallback,
    private val onPatientClicked: (Patient) -> Unit) : ListAdapter<Patient, PatientViewHolder>(patientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_patient_list_item, parent, false)
        return PatientViewHolder(containerView) {
            val car = getItem(it)
            onPatientClicked.invoke(car)
        }
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }
}