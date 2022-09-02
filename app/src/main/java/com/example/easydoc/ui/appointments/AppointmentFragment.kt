package com.example.easydoc.ui.appointments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.easydoc.DermatologistActivity
import com.example.easydoc.databinding.FragmentAppointmentBinding


class AppointmentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentAppointmentBinding.inflate(layoutInflater)
        bind.textAppointment.setOnClickListener {
            val intent =
                Intent(this@AppointmentFragment.requireContext(), DermatologistActivity::class.java)
            startActivity(intent)
        }


        return bind.root

    }

}
