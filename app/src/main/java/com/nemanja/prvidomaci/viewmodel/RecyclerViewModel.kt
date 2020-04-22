package com.nemanja.prvidomaci.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nemanja.prvidomaci.model.Patient
import kotlin.random.Random

class RecyclerViewModel : ViewModel() {
    private val patients : MutableLiveData<List<Patient>> = MutableLiveData()
    private val patientList : MutableList<Patient> = mutableListOf()

    init {
        for (i in 1..100) {
            val patient = Patient(
                i,
                "https://electric-fun.com/wp-content/uploads/2020/01/sony-car-796x418-1.jpg",
                "ime$i",
                "prezime$i",
                "hostpital$i",
                "firstState$i",
                "currentState$i",
                true,
                "$i-04-2020",
                "$i-05-2020"
            )
            patientList.add(patient)
        }
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(patientList)
        patients.value = listToSubmit
    }

    fun getPatients() : LiveData<List<Patient>> {
        return patients
    }

    fun filterPatients(name: String?, lastName: String?) {
        if (name == null && lastName == null) {
            return
        }

        val filteredList = patientList.filter {
            it.name.toLowerCase().startsWith(name?.toLowerCase() ?:it.name.toLowerCase()) &&
                    it.lastName.toLowerCase().startsWith(lastName?.toLowerCase() ?:it.lastName.toLowerCase())
        }
        patients.value = filteredList
    }

    fun addPatient(pictureUrl: String?, name: String?, lastName: String?, hospital: String?, stateOnReception: String?,
               currentState: String?, inHospital: Boolean?, dateOfArrival: String?, dateOfLeaving: String?) {
        val patient = Patient(
            Random.nextInt(101, 99999),
            pictureUrl ?: "https://us.123rf.com/450wm/mialima/mialima1603/mialima160300025/55096766-stock-vector-male-user-icon-isolated-on-a-white-background-account-avatar-for-web-user-profile-picture-unknown-ma.jpg?ver=6",
            name ?: "Jane",
            lastName ?: "Doe",
            hospital ?: "Unknown",
            stateOnReception ?: "Unknown",
            currentState ?: "Unknown",
            inHospital ?: true,
            dateOfArrival ?: "Unknown",
            dateOfLeaving ?: "Unknown"
        )
        patientList.add(patient)
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(patientList)
        patients.value = listToSubmit
    }

}