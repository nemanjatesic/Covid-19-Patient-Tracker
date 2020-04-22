package com.nemanja.prvidomaci.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import com.nemanja.prvidomaci.model.Patient

class PatientDiffItemCallback : DiffUtil.ItemCallback<Patient>() {
    override fun areItemsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Patient, newItem: Patient): Boolean {
       return oldItem.picture == newItem.picture &&
               oldItem.name == newItem.name &&
               oldItem.lastName == newItem.lastName &&
               oldItem.hospital == newItem.hospital &&
               oldItem.stateOnReception == newItem.stateOnReception &&
               oldItem.currentState == newItem.currentState &&
               oldItem.inHospital == newItem.inHospital &&
               oldItem.dateOfArrival == newItem.dateOfArrival &&
               oldItem.dateOfLeaving == newItem.dateOfLeaving
    }

}