package com.example.easydoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class PatAndDocActivity : AppCompatActivity() {
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var adapter:pat_and_docViewAdapter
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var userList: ArrayList<User>

    private lateinit var mDBref:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pat_and_doc)

        firebaseAuth=FirebaseAuth.getInstance()
        mDBref=FirebaseDatabase.getInstance().getReference()
        userList= ArrayList()
        adapter= pat_and_docViewAdapter(this,userList)

        userRecyclerView=findViewById(R.id.patAndDocRecyclerView)
        userRecyclerView.layoutManager=LinearLayoutManager(this)
        userRecyclerView.adapter=adapter
        mDBref.child("user").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                for (postSnapshot in snapshot.children){
                    val currentUser =postSnapshot.getValue(User::class.java)

                    if (firebaseAuth.currentUser?.uid!=currentUser?.uid){
                        userList.add(currentUser!!)
                    }


                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}