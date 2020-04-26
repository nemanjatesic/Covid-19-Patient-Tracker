package com.nemanja.prvidomaci.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nemanja.prvidomaci.model.Patient
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_patient_list_item_cekaonica.*

class PatientViewHolderCekaonica (
    override val containerView: View,
    onZdravClicked: (Int) -> Unit,
    onHospitalizacijaClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        buttonZdrav.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION)
                onZdravClicked.invoke(adapterPosition)
        }
        buttonHospitalizacija.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION)
                onHospitalizacijaClicked.invoke(adapterPosition)
        }
    }

    fun bind(patient: Patient) {
//        Picasso
//            .get()
//            .load(patient.picture)
//            .into(patientPictureIvContainer)
        patientNameTv.text = patient.name
        patientLastNameTv.text = patient.lastName
        patientState.text = patient.stateOnReception
    }

}
