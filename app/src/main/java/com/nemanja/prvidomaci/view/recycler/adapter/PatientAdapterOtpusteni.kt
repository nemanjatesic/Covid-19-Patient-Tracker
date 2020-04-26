package com.nemanja.prvidomaci.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.view.recycler.diff.PatientDiffItemCallback
import com.nemanja.prvidomaci.view.recycler.viewholder.PatientViewHolderOtpusteni

class PatientAdapterOtpusteni (patientDiffItemCallback: PatientDiffItemCallback) : ListAdapter<Patient, PatientViewHolderOtpusteni>(patientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolderOtpusteni {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_patient_list_item_otpusteni, parent, false)
        return PatientViewHolderOtpusteni(containerView)
    }

    override fun onBindViewHolder(holder: PatientViewHolderOtpusteni, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }

}