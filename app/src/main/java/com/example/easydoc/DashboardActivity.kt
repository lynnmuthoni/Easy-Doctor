package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.easydoc.databinding.ActivityDashboardBinding


class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.mBtnPatients.setOnClickListener {
            val intent= Intent(this,PatientSignInActivity::class.java)
            startActivity(intent)

        }


        binding.mBtnAdmin.setOnClickListener {
            val intent= Intent(this,AdminLogin::class.java)
            startActivity(intent)

        }
        binding.mBtnDoctor.setOnClickListener {
            val intent= Intent(this,DoctorLoginActivity::class.java)
            startActivity(intent)

        }
    }
}