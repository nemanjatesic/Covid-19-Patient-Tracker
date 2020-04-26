package com.nemanja.prvidomaci.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Patient(
    val id: UUID,
    val picture: String,
    val name: String,
    val lastName: String,
    val hospital: String,
    val stateOnReception: String,
    val currentState: String,
    val inHospital: Boolean,
    val dateOfArrival: Date,
    val dateOfHospitalization: Date?,
    val dateOfLeaving: Date?
) : Parcelable