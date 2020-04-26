package com.nemanja.prvidomaci.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.model.PatientFactory
import java.util.*
import kotlin.random.Random

class SharedViewModel : ViewModel() {

    companion object {
        const val CEKAONICA = 0
        const val HOSPITALIZOVANI = 1
        const val OTPUSTENI = 2
    }

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

    fun addPatient(patient: Patient, type: Int) {
        val tmp: MutableList<Patient> = when (type){
            CEKAONICA -> cekaonicaPacijenti.value
            HOSPITALIZOVANI -> hospitalizovaniPacijenti.value
            else -> otpusteniPacijenti.value
        } ?: mutableListOf()
        tmp.add(patient)
        when (type) {
            CEKAONICA -> cekaonicaPacijenti.value = tmp
            HOSPITALIZOVANI -> hospitalizovaniPacijenti.value = tmp
            else -> otpusteniPacijenti.value = tmp
        }
    }

    fun removePatient(patient: Patient, type: Int) {
        val tmp: MutableList<Patient> = when (type){
            CEKAONICA -> cekaonicaPacijenti.value
            HOSPITALIZOVANI -> hospitalizovaniPacijenti.value
            else -> otpusteniPacijenti.value
        } ?: return
        tmp.remove(patient)
        when (type) {
            CEKAONICA -> cekaonicaPacijenti.value = tmp
            HOSPITALIZOVANI -> hospitalizovaniPacijenti.value = tmp
            else -> otpusteniPacijenti.value = tmp
        }
    }

}