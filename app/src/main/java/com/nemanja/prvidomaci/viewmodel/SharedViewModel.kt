package com.nemanja.prvidomaci.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nemanja.prvidomaci.model.Patient
import kotlin.random.Random

class SharedViewModel : ViewModel() {

    private val cekaonicaPacijenti : MutableLiveData<MutableList<Patient>> = MutableLiveData()
    private val hospitalizovaniPacijenti : MutableLiveData<MutableList<Patient>> = MutableLiveData()
    private val otpusteniPacijenti : MutableLiveData<MutableList<Patient>> = MutableLiveData()

    fun getCekaonicaPacijenti() : LiveData<MutableList<Patient>> {
        return cekaonicaPacijenti
    }

    fun getHospitalizovaniPacijenti() : LiveData<MutableList<Patient>> {
        return hospitalizovaniPacijenti
    }

    fun getOtpusteniPacijenti() : LiveData<MutableList<Patient>> {
        return otpusteniPacijenti
    }

    fun addPatientToCekaonica(patient: Patient) {
        var tmp = cekaonicaPacijenti.value
        if (tmp == null)
            tmp = mutableListOf()
        tmp.add(patient)
        cekaonicaPacijenti.value = tmp
    }

    fun addRandom() {
        var tmp = cekaonicaPacijenti.value
        if (tmp == null) {
            tmp = mutableListOf<Patient>()
        }
        tmp.add(addPatient(null,null,null,null,null,null,null,null,null))
        cekaonicaPacijenti.value = tmp
    }

    private fun addPatient(pictureUrl: String?, name: String?, lastName: String?, hospital: String?, stateOnReception: String?,
                           currentState: String?, inHospital: Boolean?, dateOfArrival: String?, dateOfLeaving: String?) : Patient{
        return Patient(
            Random.nextInt(101, 99999),
            pictureUrl
                ?: "https://us.123rf.com/450wm/mialima/mialima1603/mialima160300025/55096766-stock-vector-male-user-icon-isolated-on-a-white-background-account-avatar-for-web-user-profile-picture-unknown-ma.jpg?ver=6",
            name ?: "Jane",
            lastName ?: "Doe",
            hospital ?: "Unknown",
            stateOnReception ?: "Unknown",
            currentState ?: "Unknown",
            inHospital ?: true,
            dateOfArrival ?: "Unknown",
            dateOfLeaving ?: "Unknown"
        )
    }

}