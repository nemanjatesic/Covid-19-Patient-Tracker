package com.nemanja.prvidomaci.view.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemanja.prvidomaci.R
import com.nemanja.prvidomaci.view.activities.StyledActivity
import com.nemanja.prvidomaci.view.recycler.adapter.PatientAdapter
import com.nemanja.prvidomaci.view.recycler.diff.PatientDiffItemCallback
import com.nemanja.prvidomaci.viewmodel.RecyclerViewModel
import com.nemanja.prvidomaci.viewmodel.SharedViewModel
import com.squareup.picasso.Picasso
import com.thekhaeng.recyclerviewmargin.LayoutMarginDecoration
import kotlinx.android.synthetic.main.activity_classic_recycler.*
import kotlinx.android.synthetic.main.fragment_profil.*
import timber.log.Timber

class CekaonicaFragment : Fragment(R.layout.activity_classic_recycler) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var patientAdapter: PatientAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
    }

    private fun initUi() {
        initObservers()
        initListeners()
        initRecycler()
    }

    private fun initListeners() {
//        et_search_cekaonica.doAfterTextChanged {
//            recyclerViewModel.filterPatients(it.toString(),null)
//        }
//        doMagicBtn.setOnClickListener {
//            recyclerViewModel.addPatient(PatientFactory().createPatient())
//        }
    }

    private fun initRecycler() {
        listRvCekaonica.layoutManager = LinearLayoutManager(activity)
        patientAdapter = PatientAdapter(PatientDiffItemCallback()) {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, StyledActivity::class.java)
            startActivity(intent)
        }
        listRvCekaonica.adapter = patientAdapter
        listRvCekaonica.addItemDecoration(LayoutMarginDecoration(1,toDP(activity?.applicationContext,20)))
    }

    private fun initObservers() {
        sharedViewModel.getCekaonicaPacijenti().observe(viewLifecycleOwner, Observer {
            Timber.e("Ovde")
            patientAdapter.submitList(it)
        })
    }

    private fun toDP(context: Context?, value: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            value.toFloat(),context?.resources?.displayMetrics).toInt()
    }
}