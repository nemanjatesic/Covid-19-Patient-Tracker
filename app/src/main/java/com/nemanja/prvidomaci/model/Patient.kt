package com.nemanja.prvidomaci.model

import java.util.*

data class Patient(
    val id: Int,
    val picture: String,
    val name: String,
    val lastName: String,
    val hospital: String,
    val stateOnReception: String,
    val currentState: String,
    val inHospital: Boolean,
    val dateOfArrival: Date,
    val dateOfLeaving: Date
)