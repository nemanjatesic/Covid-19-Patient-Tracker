package com.nemanja.prvidomaci.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.model.Patient
import com.nemanja.prvidomaci.model.PatientFactory
import com.nemanja.prvidomaci.view.recycler.adapter.PatientAdapter
import com.nemanja.prvidomaci.view.recycler.diff.PatientDiffItemCallback
import com.nemanja.prvidomaci.viewmodel.RecyclerViewModel
import kotlinx.android.synthetic.main.activity_classic_recycler.*

class RecyclerActivity : AppCompatActivity(R.layout.activity_classic_recycler) {

    private val recyclerViewModel: RecyclerViewModel by viewModels()

    private lateinit var patientAdapter: PatientAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initObservers()
    }

    private fun initUi() {
        initListeners()
        initRecycler()
    }

    private fun initListeners() {
        inputEt.doAfterTextChanged {
            recyclerViewModel.filterPatients(it.toString(),null)
        }
        doMagicBtn.setOnClickListener {
            recyclerViewModel.addPatient(PatientFactory().createPatient())
        }
    }

    private fun initRecycler() {
        listRv.layoutManager = LinearLayoutManager(this)
        patientAdapter = PatientAdapter(PatientDiffItemCallback()) {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            // Ako hocemo da otvorimo novi activity klikom na item u listi
            // to radimo ovde, ne prosledjujemo context u listadapter ili viewholder
            val intent = Intent(this, StyledActivity::class.java)
            startActivity(intent)
        }
        listRv.adapter = patientAdapter
    }

    private fun initObservers() {
        recyclerViewModel.getPatients().observe(this, Observer {
            patientAdapter.submitList(it)
        })
    }
}
