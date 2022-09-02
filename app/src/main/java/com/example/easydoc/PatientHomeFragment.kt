package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.easydoc.databinding.ActivityPatientHomeFragmentBinding

class PatientHomeFragment : AppCompatActivity() {
    private lateinit var binding:ActivityPatientHomeFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityPatientHomeFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.buttonOrthopedic.setOnClickListener {
           val intent= Intent(this,DermatologistActivity::class.java)
           startActivity(intent)
       }
        binding.buttonDentist.setOnClickListener {
           val intent= Intent(this,DermatologistActivity::class.java)
           startActivity(intent)
       }
        binding.buttonDermatology.setOnClickListener {
           val intent= Intent(this,DermatologistActivity::class.java)
           startActivity(intent)
       }
        binding.buttonPediatrician.setOnClickListener {
           val intent= Intent(this,DermatologistActivity::class.java)
           startActivity(intent)
       }
    }
}