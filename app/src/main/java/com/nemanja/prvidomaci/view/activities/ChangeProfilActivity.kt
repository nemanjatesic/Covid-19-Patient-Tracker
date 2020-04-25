package com.nemanja.prvidomaci.view.activities

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nemanja.prvidomaci.R
import kotlinx.android.synthetic.main.activity_profile_change.*

class ChangeProfilActivity : AppCompatActivity(R.layout.activity_profile_change) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setInformation()
        initListeners()
    }

    private fun initListeners(){
        buttonChange.setOnClickListener {
            if (checkText(et_user_name_change, "Polje ime ne sme da bude prazno") &&
                checkText(et_user_lastname_change, "Polje prezime ne sme da bude prazno") &&
                    checkText(et_user_hospital_change, "Polje bolnica ne sme da bude prazno")) {
                val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString(LoginActivity.USER_NAME,et_user_name_change.text.toString())
                editor.putString(LoginActivity.USER_LAST_NAME,et_user_lastname_change.text.toString())
                editor.putString(LoginActivity.USER_HOSPITAL,et_user_hospital_change.text.toString())
                editor.apply()
                Toast.makeText(applicationContext,"Profil azuriran", Toast.LENGTH_SHORT).show()
                finish()
            }

        }

        buttonOdustani.setOnClickListener {
            finish()
        }
    }

    private fun setInformation() {
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val ime = sharedPreferences.getString(LoginActivity.USER_NAME, "Unknown")
        val prezime = sharedPreferences.getString(LoginActivity.USER_LAST_NAME,"Unknown")
        val bolnica = sharedPreferences.getString(LoginActivity.USER_HOSPITAL,"Unknown")

        et_user_name_change.setText(ime)
        et_user_lastname_change.setText(prezime)
        et_user_hospital_change.setText(bolnica)
    }

    private fun checkText(text: EditText, textOut: String): Boolean {
        if (text.text.isEmpty()) {
            Toast.makeText(applicationContext,textOut,Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}