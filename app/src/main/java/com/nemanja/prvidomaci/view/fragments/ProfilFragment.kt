package com.nemanja.prvidomaci.view.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.view.activities.LoginActivity
import com.nemanja.prvidomaci.view.activities.RecyclerActivity
import kotlinx.android.synthetic.main.fragment_profil.*

class ProfilFragment : Fragment(R.layout.fragment_profil) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
        setInformation()
    }

    private fun setInformation() {
        val ime = textViewProfilIme
        val prezime = textViewProfilPrezime
        val bolnica = textViewProfilBolnica

        val sharedPreferences = activity?.getSharedPreferences(activity?.packageName, Context.MODE_PRIVATE)
        ime.text = sharedPreferences?.getString(LoginActivity.USER_NAME, "Unknown")
        prezime.text = sharedPreferences?.getString(LoginActivity.USER_LAST_NAME,"Unknown")
        bolnica.text = sharedPreferences?.getString(LoginActivity.USER_HOSPITAL,"Unknown")
    }

    private fun initListeners() {
        buttonProfilOdjava.setOnClickListener {
            val sharedPreferences = activity?.getSharedPreferences(activity?.packageName, Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor?.putBoolean(LoginActivity.LOGGED_IN_KEY, false)
            editor?.putString(LoginActivity.USER_NAME, null)
            editor?.putString(LoginActivity.USER_LAST_NAME, null)
            editor?.putString(LoginActivity.USER_HOSPITAL, null)
            editor?.apply()

            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
}