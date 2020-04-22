package com.nemanja.prvidomaci.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nemanja.prvidomaci.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){
    companion object {
        const val LOGGED_IN_KEY = "loggedIn"
        const val BELGRADE_PIN = 4200
        const val VALJEVO_PIN = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button_login_prijava.setOnClickListener {
            if (checkText(et_user_name, "Molimo vas unesite ime") &&
                checkText(et_user_lastname, "Molimo vas unesite prezime") &&
                checkText(et_user_hospital, "Molimo vas unesite ime bolnice") && checkPin(et_pin.text)) {
                val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putBoolean(LOGGED_IN_KEY, true)
                editor.apply()
                val intent = Intent(this, RecyclerActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun checkText(text: EditText, textOut: String): Boolean {
        if (text.text.isEmpty()) {
            Toast.makeText(applicationContext,textOut,Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun checkPin(pin: Editable): Boolean {
        val pinSize: Int = pin.length
        val pinString = pin.toString()
        if (pinSize != 4) {
            Toast.makeText(applicationContext,"Pin mora imati 4 cifre",Toast.LENGTH_SHORT).show()
            return false
        }
        val pinNum = pinString.toInt()
        return if (pinNum == BELGRADE_PIN || pinNum == VALJEVO_PIN) {
            true
        }else {
            Toast.makeText(applicationContext,"Pin nije tacan",Toast.LENGTH_SHORT).show()
            false
        }
    }
}