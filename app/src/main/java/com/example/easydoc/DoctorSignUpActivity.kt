package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.easydoc.databinding.ActivityDoctorSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DoctorSignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorSignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var mDBRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityDoctorSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.mTvLoginPage.setOnClickListener {
            val intent= Intent(this,DoctorLoginActivity::class.java)
            startActivity(intent)
        }

        binding.mDocBtnRegister.setOnClickListener {
            val useremail=binding.mDocEdtEmail.text.toString()
            val username=binding.mDocEdtName.text.toString()
            val userpass=binding.mDocEdtPassword.text.toString()
            val userdepartment=binding.mDocEdtDepartment.text.toString()
            val userphonenumber=binding.mDocEdtPhoneNumber.text.toString()
            val userconfirmpass=binding.mDocEdtConfirmPassword.text.toString()


            //Check if user field is empty
            if (username.isEmpty()|| useremail.isEmpty()||userphonenumber.isEmpty()||userpass.isEmpty()||userdepartment.isEmpty()
                ||userconfirmpass.isEmpty()){
                Toast.makeText(this,"Please fill in all the fields", Toast.LENGTH_LONG).show()
            }
            else if (userpass == userconfirmpass){

                firebaseAuth.createUserWithEmailAndPassword(useremail,userpass).addOnCompleteListener {
                    if (it.isSuccessful){

                        addUserToDatabase(username,useremail,firebaseAuth.currentUser?.uid!!)
                        val intent= Intent(this,DoctorLoginActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }}

            else{
                Toast.makeText(this,"Passwords don't match", Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun addUserToDatabase(username: String, useremail: String, uid: String) {
mDBRef=FirebaseDatabase.getInstance().getReference()
mDBRef.child("user").child(uid).setValue(User(username,useremail,uid))
    }


}



