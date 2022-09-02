package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.easydoc.databinding.ActivityAdminBinding
import com.example.easydoc.databinding.ActivityAdminLoginBinding

class Admin : AppCompatActivity() {
    private lateinit var binding:ActivityAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_admin)


        binding.buttonadmindoc.setOnClickListener {
            val intent= Intent(this,UsersActivity::class.java)
            startActivity(intent)

        }
    }
}