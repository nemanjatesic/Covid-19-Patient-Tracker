package com.nemanja.prvidomaci.model

import kotlin.random.Random

class PatientFactory {

    companion object {
        const val unknownImage: String = "https://us.123rf.com/450wm/mialima/mialima1603/mialima160300025/55096766-stock-vector-male-user-icon-isolated-on-a-white-background-account-avatar-for-web-user-profile-picture-unknown-ma.jpg?ver=6"
        const val unknown: String = "Unknown"
    }

    fun createPatient(pictureUrl: String? = unknownImage, name: String? = "Jane", lastName: String? = "Doe", hospital: String? = unknown, stateOnReception: String? = unknown,
                           currentState: String? = unknown, inHospital: Boolean? = true, dateOfArrival: String? = unknown, dateOfLeaving: String? = unknown) : Patient{
        return Patient(
            Random.nextInt(101, 99999),
            pictureUrl ?: unknownImage,
            name ?: "Jane",
            lastName ?: "Doe",
            hospital ?: unknown,
            stateOnReception ?: unknown,
            currentState ?: unknown,
            inHospital ?: true,
            dateOfArrival ?: unknown,
            dateOfLeaving ?: unknown
        )
    }
}