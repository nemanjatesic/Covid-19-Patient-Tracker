package com.nemanja.prvidomaci.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nemanja.prvidomaci.model.Patient
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_patient_list_item_otpusteni.*
import java.text.SimpleDateFormat

class PatientViewHolderOtpusteni (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(patient: Patient) {
        patientNameTvOtp.text = patient.name
        patientLastNameTvOtp.text = patient.lastName
        val sdf = SimpleDateFormat("dd.MM.yyyy")
        if (patient.dateOfLeaving != null)
            patientReleaseDateOtp.text = sdf.format(patient.dateOfLeaving)
    }
}
