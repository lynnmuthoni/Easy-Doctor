package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.easydoc.databinding.ActivityAdminLoginBinding
import com.example.easydoc.databinding.ActivityPatientsloginBinding

class AdminLogin : AppCompatActivity() {


    private lateinit var binding: ActivityAdminLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAdminLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.mAdminBtnLogin.setOnClickListener{
            var adminName =binding.mAdminEdtName.text.toString()
            var adminEmail = binding.mAdminEdtEmail.text.toString()
            var adminPassword = binding.mAdminEdtPassword.text.toString()


            if (adminName.isNotEmpty() && adminEmail.isNotEmpty()&&adminPassword.isNotEmpty()){

                val intent= Intent(this,PatAndDocActivity::class.java)
                startActivity(intent)
                finish()

            }else{ messages( "Empty Fields", "Please fill in all inputs")

            }
        }

    }

    private fun messages(Title: String, message: String) {
        var alertDialog= AlertDialog.Builder(this)
        alertDialog.setTitle(Title)
        alertDialog.setMessage(message)
        alertDialog.create().show()
    }
    }
