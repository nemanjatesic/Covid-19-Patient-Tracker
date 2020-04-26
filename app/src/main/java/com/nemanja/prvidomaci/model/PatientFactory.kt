package com.nemanja.prvidomaci.model

import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class PatientFactory {

    companion object {
        const val unknownImage: String = "https://us.123rf.com/450wm/mialima/mialima1603/mialima160300025/55096766-stock-vector-male-user-icon-isolated-on-a-white-background-account-avatar-for-web-user-profile-picture-unknown-ma.jpg?ver=6"
        const val unknown: String = "Unknown"
        private val sdf = SimpleDateFormat("dd-MM-yyyy")
        val unknownDate: Date = sdf.parse("10-10-1980") ?: Date()
    }

    fun createPatient(pictureUrl: String? = unknownImage, name: String? = "Jane", lastName: String? = "Doe", hospital: String? = unknown, stateOnReception: String? = unknown,
                      currentState: String? = unknown, inHospital: Boolean? = true, dateOfArrival: Date? = unknownDate, dateOfHospitalization: Date? = null, dateOfLeaving: Date? = null) : Patient {
        return Patient(
            UUID.randomUUID(),
            pictureUrl ?: unknownImage,
            name ?: "Jane",
            lastName ?: "Doe",
            hospital ?: unknown,
            stateOnReception ?: unknown,
            currentState ?: unknown,
            inHospital ?: true,
            dateOfArrival ?: unknownDate,
            dateOfHospitalization,
            dateOfLeaving
        )
    }

    fun getFirstDate(): Date {
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        return sdf.parse("10-10-1980") ?: Date()
    }
}