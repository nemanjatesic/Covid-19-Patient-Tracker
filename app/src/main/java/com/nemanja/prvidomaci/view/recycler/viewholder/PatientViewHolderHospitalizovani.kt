package com.nemanja.prvidomaci.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nemanja.prvidomaci.model.Patient
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_patient_list_item_hospitalizacija.*

class PatientViewHolderHospitalizovani (
    override val containerView: View,
    onKartonClicked: (Int) -> Unit,
    onOtpustClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        buttonKarton.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION)
                onKartonClicked.invoke(adapterPosition)
        }
        buttonOtpust.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION)
                onOtpustClicked.invoke(adapterPosition)
        }
    }

    fun bind(patient: Patient) {
        patientNameTvHos.text = patient.name
        patientLastNameTvHos.text = patient.lastName
    }

}
