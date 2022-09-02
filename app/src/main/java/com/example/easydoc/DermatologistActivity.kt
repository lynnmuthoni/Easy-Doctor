package com.example.easydoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class DermatologistActivity : AppCompatActivity() {

   private lateinit var userRecyclerView: RecyclerView
   private  lateinit var userList:ArrayList <User>
   private lateinit var adapter: UserAdapter
   private lateinit var firebaseAuth: FirebaseAuth
   private lateinit var mDBref:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dermatologist)

        userList= ArrayList()

        mDBref=FirebaseDatabase.getInstance().getReference()
        adapter=UserAdapter(this,userList)
        firebaseAuth=FirebaseAuth.getInstance()
        userRecyclerView=findViewById(R.id.docList)
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