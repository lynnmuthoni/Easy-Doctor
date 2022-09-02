package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.easydoc.databinding.ActivityDoctorLoginBinding

import com.google.firebase.auth.FirebaseAuth

class DoctorLoginActivity : AppCompatActivity() {
     private lateinit var binding: ActivityDoctorLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=  ActivityDoctorLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth= FirebaseAuth.getInstance()

        binding.mTvRegisterPage.setOnClickListener {
            val intent= Intent(this,DoctorSignUpActivity::class.java)
            startActivity(intent)
        }
        binding.mBtnLogin.setOnClickListener {
            val useremail=binding.mDocedtEmail.text.toString()
            val userpass=binding.mDocedtPassword.text.toString()



            //Check if user field is empty
            if ( useremail.isEmpty()||userpass.isEmpty()) {

                Toast.makeText(this,"Please fill in all the fields", Toast.LENGTH_LONG).show()
            }


            else{
                firebaseAuth.signInWithEmailAndPassword(useremail,userpass).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent= Intent(this,DoctorHomeActivty::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            }

        }

    }
}