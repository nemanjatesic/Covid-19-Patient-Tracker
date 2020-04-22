package com.nemanja.prvidomaci.model

data class Patient(
    val id: Int,
    val picture: String,
    val name: String,
    val lastName: String,
    val hospital: String,
    val stateOnReception: String,
    val currentState: String,
    val inHospital: Boolean,
    val dateOfArrival: String,
    val dateOfLeaving: String
)