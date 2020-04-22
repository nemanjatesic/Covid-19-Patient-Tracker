package com.nemanja.prvidomaci.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nemanja.prvidomaci.model.Patient
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_patient_list_item.*

class PatientViewHolder (
    override val containerView: View,
    onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        patientPictureIv.setOnClickListener {
            onItemClicked.invoke(adapterPosition)
        }
    }

    fun bind(patient: Patient) {
        Picasso
            .get()
            .load(patient.picture)
            .into(patientPictureIv)
        patientNameTv.text = patient.name
        patientLastNameTv.text = patient.lastName
        patientState.text = patient.currentState
    }

}