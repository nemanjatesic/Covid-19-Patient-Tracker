package com.nemanja.prvidomaci.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DodajViewModel : ViewModel() {
    private val imeLiveData: MutableLiveData<String> = MutableLiveData()
    private val prezimeLiveData: MutableLiveData<String> = MutableLiveData()
    private val simptopmiLiveData: MutableLiveData<String> = MutableLiveData()

    fun getIme() : LiveData<String> {
        return imeLiveData
    }

    fun storeIme(ime: String) {
        imeLiveData.value = ime
    }

    fun getPrezime() : LiveData<String> {
        return prezimeLiveData
    }

    fun storePrezime(prezime: String) {
        prezimeLiveData.value = prezime
    }

    fun getSimptomi() : LiveData<String> {
        return simptopmiLiveData
    }

    fun storeSimptomi(simptomi: String) {
        simptopmiLiveData.value = simptomi
    }

}