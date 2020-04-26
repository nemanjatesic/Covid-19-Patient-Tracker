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

    private val cekaonicaPacijenti : MutableLiveData<List<Patient>> = MutableLiveData()
    private val hospitalizovaniPacijenti : MutableLiveData<List<Patient>> = MutableLiveData()
    private val otpusteniPacijenti : MutableLiveData<List<Patient>> = MutableLiveData()

    private val cekaonicaPacijentiList: MutableList<Patient> = mutableListOf()
    private val hospitalizovaniPacijentiList : MutableList<Patient> = mutableListOf()
    private val otpusteniPacijentiList : MutableList<Patient> = mutableListOf()


    init {
        val factory = PatientFactory()
        for (i in 1..15) {
            val patient = factory.createPatient(dateOfArrival = Date())
            cekaonicaPacijentiList.add(patient)
        }
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(cekaonicaPacijentiList)
        cekaonicaPacijenti.value = listToSubmit
    }

    fun getCekaonicaPacijenti() : LiveData<List<Patient>> {
        return cekaonicaPacijenti
    }

    fun getHospitalizovaniPacijenti() : LiveData<List<Patient>> {
        return hospitalizovaniPacijenti
    }

    fun getOtpusteniPacijenti() : LiveData<List<Patient>> {
        return otpusteniPacijenti
    }

    fun addPatient(patient: Patient, type: Int) {
        val listToSubmit = mutableListOf<Patient>()
        when (type) {
            CEKAONICA -> {
                cekaonicaPacijentiList.add(patient)
                listToSubmit.addAll(cekaonicaPacijentiList)
                cekaonicaPacijenti.value = listToSubmit
            }
            HOSPITALIZOVANI -> {
                hospitalizovaniPacijentiList.add(patient)
                listToSubmit.addAll(hospitalizovaniPacijentiList)
                hospitalizovaniPacijenti.value = listToSubmit
            }
            else -> {
                otpusteniPacijentiList.add(patient)
                listToSubmit.addAll(otpusteniPacijentiList)
                otpusteniPacijenti.value = listToSubmit
            }
        }
    }

    fun removePatient(patient: Patient, type: Int) {
        val listToSubmit = mutableListOf<Patient>()
        when (type) {
            CEKAONICA -> {
                cekaonicaPacijentiList.remove(patient)
                listToSubmit.addAll(cekaonicaPacijentiList)
                cekaonicaPacijenti.value = listToSubmit
            }
            HOSPITALIZOVANI -> {
                hospitalizovaniPacijentiList.remove(patient)
                listToSubmit.addAll(hospitalizovaniPacijentiList)
                hospitalizovaniPacijenti.value = listToSubmit
            }
            else -> {
                otpusteniPacijentiList.remove(patient)
                listToSubmit.addAll(otpusteniPacijentiList)
                otpusteniPacijenti.value = listToSubmit
            }
        }
    }

    fun filterPatients(str: String?, type: Int) {
        if (str == null)
            return
        val patientList = when(type) {
            CEKAONICA -> cekaonicaPacijentiList
            HOSPITALIZOVANI -> hospitalizovaniPacijentiList
            else -> otpusteniPacijentiList
        }
        val patients: MutableLiveData<List<Patient>> = when(type) {
            CEKAONICA -> cekaonicaPacijenti
            HOSPITALIZOVANI -> hospitalizovaniPacijenti
            else -> otpusteniPacijenti
        }

        val filteredList = patientList.filter {
            val name:String = replaceAll(it.name)
            val lastName = replaceAll(it.lastName)
            name.contains(replaceAll(str)) || lastName.contains(replaceAll(str))
        }
        patients.value = filteredList
    }

    fun getPatientById(uuid: UUID, type: Int): Patient? {
        when (type) {
            CEKAONICA -> cekaonicaPacijentiList.forEach { if (it.id == uuid) return it }
            HOSPITALIZOVANI -> hospitalizovaniPacijentiList.forEach { if (it.id == uuid) return it }
            OTPUSTENI -> otpusteniPacijentiList.forEach { if (it.id == uuid) return it }
        }
        return null
    }

    private fun replaceAll(strIn: String): String {
        var str = strIn.toLowerCase(Locale.ROOT)
        str = str.replace('č','c', ignoreCase = false)
        str = str.replace('ć','c', ignoreCase = false)
        str = str.replace('š','s', ignoreCase = false)
        str = str.replace("đ","dj", ignoreCase = false)
        str = str.replace('ž','z', ignoreCase = false)
        return str
    }

}