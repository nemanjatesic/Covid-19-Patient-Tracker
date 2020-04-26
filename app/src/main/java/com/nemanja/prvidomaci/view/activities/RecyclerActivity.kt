package com.nemanja.prvidomaci.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.view.recycler.adapter.PatientAdapterCekaonica
import com.nemanja.prvidomaci.viewmodel.RecyclerViewModel

class RecyclerActivity : AppCompatActivity(R.layout.activity_classic_recycler) {

    private val recyclerViewModel: RecyclerViewModel by viewModels()

    private lateinit var patientAdapter: PatientAdapterCekaonica

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
//        inputEt.doAfterTextChanged {
//            recyclerViewModel.filterPatients(it.toString(),null)
//        }
//        doMagicBtn.setOnClickListener {
//            recyclerViewModel.addPatient(PatientFactory().createPatient())
//        }
    }

    private fun initRecycler() {
//        listRv.layoutManager = LinearLayoutManager(this)
//        patientAdapter = PatientAdapter(PatientDiffItemCallback()) {
//            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
//            // Ako hocemo da otvorimo novi activity klikom na item u listi
//            // to radimo ovde, ne prosledjujemo context u listadapter ili viewholder
//            val intent = Intent(this, StyledActivity::class.java)
//            startActivity(intent)
//        }
//        listRv.adapter = patientAdapter
    }

    private fun initObservers() {
        recyclerViewModel.getPatients().observe(this, Observer {
            patientAdapter.submitList(it)
        })
    }
}
