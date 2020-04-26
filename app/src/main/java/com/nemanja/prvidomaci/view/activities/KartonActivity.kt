package com.nemanja.prvidomaci.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.model.PatientFactory
import com.nemanja.prvidomaci.view.fragments.HospitalizovaniFragment
import kotlinx.android.synthetic.main.activity_karton_pacijenta.*
import java.text.SimpleDateFormat

class KartonActivity : AppCompatActivity(R.layout.activity_karton_pacijenta) {

    private lateinit var patient: Patient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        patient = intent.getParcelableExtra(HospitalizovaniFragment.MESSAGE_PATIENT) ?: PatientFactory().createPatient()
        init()
        initListeners()
    }

    private fun init() {
        et_patient_name_change.setText(patient.name)
        et_patient_lastname_change.setText(patient.lastName)
        et_patient_state_on_reception_change.setText(patient.stateOnReception)
        et_patient_current_state_change.setText(patient.currentState)
        if (patient.dateOfHospitalization != null)
            textViewDatumPrijema.text = SimpleDateFormat("dd.MM.yyyy").format(patient.dateOfHospitalization)
        else
            textViewDatumPrijema.text = "Unknown"
    }

    private fun initListeners() {
        val factory = PatientFactory()
        buttonPacijentIzmeni.setOnClickListener {
            if (checkText(et_patient_name_change, "Molimo vas unesite ime pacijenta") &&
                checkText(et_patient_lastname_change, "Molimo vas unesite prezime pacijenta") &&
                checkText(et_patient_state_on_reception_change, "Molimo vas unesite stanje pacijenta pri prijemu") &&
                checkText(et_patient_current_state_change, "Molimo vas unesite trenutno stanje pacijenta")) {
                val returnIntent = Intent()
                val returnPatient = factory.copyPatient(patient, name = et_patient_name_change.text.toString(), lastName = et_patient_lastname_change.text.toString()
                    , stateOnReception = et_patient_state_on_reception_change.text.toString(), currentState = et_patient_current_state_change.text.toString())
                returnIntent.putExtra(HospitalizovaniFragment.MESSAGE_PATIENT, returnPatient)
                setResult(Activity.RESULT_OK, returnIntent)
                finish()
            }
        }
        buttonPacijentOdustani.setOnClickListener {
            val returnIntent = Intent()
            setResult(Activity.RESULT_CANCELED, returnIntent)
            finish()
        }
    }


    private fun checkText(text: EditText, textOut: String): Boolean {
        if (text.text.isEmpty()) {
            Toast.makeText(applicationContext,textOut, Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}