package com.nemanja.prvidomaci.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.view.recycler.diff.PatientDiffItemCallback
import com.nemanja.prvidomaci.view.recycler.viewholder.PatientViewHolderHospitalizovani

class PatientAdapterHospitalizovani (
    patientDiffItemCallback: PatientDiffItemCallback,
    private val onKartonClicked: (Patient) -> Unit,
    private val onOtpustClicked: (Patient) -> Unit) : ListAdapter<Patient, PatientViewHolderHospitalizovani>(patientDiffItemCallback) {

    private val functionKarton: (Int) -> Unit =  {
        if (it >= 0) {
            val patient = getItem(it)
            onKartonClicked.invoke(patient)
        }
    }

    private val functionOtpust: (Int) -> Unit =  {
        if (it >= 0) {
            val patient = getItem(it)
            onOtpustClicked.invoke(patient)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolderHospitalizovani {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_patient_list_item_hospitalizacija, parent, false)
        return PatientViewHolderHospitalizovani(containerView, functionKarton, functionOtpust)
    }

    override fun onBindViewHolder(holder: PatientViewHolderHospitalizovani, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }

}