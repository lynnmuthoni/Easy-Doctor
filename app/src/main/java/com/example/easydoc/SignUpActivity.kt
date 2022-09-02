package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.easydoc.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var mDBRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.mTvLoginPage.setOnClickListener {
            val intent= Intent(this,PatientSignInActivity::class.java)
            startActivity(intent)
        }

        binding.mBtnRegister.setOnClickListener {
            val useremail=binding.mEdtEmail.text.toString()
            val username=binding.mEdtName.text.toString()
            val userpass=binding.mEdtPassword.text.toString()
            val userphonenumber=binding.mEdtPhoneNumber.text.toString()
            val userconfirmpass=binding.mEdtConfirmPassword.text.toString()


            //Check if user field is empty
           if (username.isEmpty()|| useremail.isEmpty()||userphonenumber.isEmpty()||userpass.isEmpty()
               ||userconfirmpass.isEmpty()){
               Toast.makeText(this,"Please fill in all the fields",Toast.LENGTH_LONG).show()
           }
           else if (userpass == userconfirmpass){
                firebaseAuth.createUserWithEmailAndPassword(useremail,userpass).addOnCompleteListener {
                    if (it.isSuccessful){
                        addUserToDatabase(username,useremail,firebaseAuth.currentUser?.uid!!)
                        val intent= Intent(this,PatientSignInActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,it.exception.toString(),Toast.LENGTH_LONG).show()
                    }
            }}

            else{
                Toast.makeText(this,"Passwords don't match",Toast.LENGTH_LONG).show()
                }
            }

        }
    private fun addUserToDatabase(username: String, useremail: String, uid: String) {
        mDBRef=FirebaseDatabase.getInstance().getReference()
        mDBRef.child("user").child(uid).setValue(User(username,useremail,uid))
    }

    }



