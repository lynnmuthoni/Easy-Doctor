package com.example.easydoc

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.easydoc.databinding.ActivityPatientHomeFragmentBinding
import com.example.easydoc.databinding.ActivityPatientsAmbulanceFragmentBinding

class PatientsAmbulanceFragment : AppCompatActivity() {

    private lateinit var binding:ActivityPatientsAmbulanceFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patients_ambulance_fragment)



        binding= ActivityPatientsAmbulanceFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mBtnCall.setOnClickListener {

                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "911"))
                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
//                  request
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        1
                    )
                } else {
                    startActivity(intent)
                }
            }
        }
    }
