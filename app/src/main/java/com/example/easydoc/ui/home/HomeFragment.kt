package com.example.easydoc.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easydoc.DermatologistActivity
import com.example.easydoc.DoctorLoginActivity
import com.example.easydoc.R
import com.example.easydoc.UsersActivity
import com.example.easydoc.databinding.ActivityDoctorSignUpBinding
import com.example.easydoc.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ?{
        val bind =FragmentHomeBinding.inflate(layoutInflater)
        bind.buttonOrthopedic.setOnClickListener {
            val  intent=Intent(this@HomeFragment.requireContext(),DermatologistActivity::class.java)
            startActivity(intent)
        }
        bind.buttonDermatology.setOnClickListener {
            val  intent=Intent(this@HomeFragment.requireContext(),DermatologistActivity::class.java)
            startActivity(intent)
        }
        bind.buttonDentist.setOnClickListener {
            val  intent=Intent(this@HomeFragment.requireContext(),DermatologistActivity::class.java)
            startActivity(intent)
        }
        bind.buttonPediatrician.setOnClickListener {
            val  intent=Intent(this@HomeFragment.requireContext(),DermatologistActivity::class.java)
            startActivity(intent)
        }

        return bind.root

    }


}