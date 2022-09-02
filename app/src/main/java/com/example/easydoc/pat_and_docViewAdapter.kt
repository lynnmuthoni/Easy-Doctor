package com.example.easydoc

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
//Connect to the users table/child to fetch data



class pat_and_docViewAdapter(val context: Context, val userlist:ArrayList<User> ):
    RecyclerView.Adapter<pat_and_docViewAdapter.UserViewHolder>() {

    val reference=FirebaseDatabase.getInstance().getReference().child("Users")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.pat_doc_users, parent, false)
        return UserViewHolder(view)
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userlist[position]
        holder.textName.text = currentUser.name
        holder.textEmail.text = currentUser.email

        holder.itemView.setOnClickListener {
            val userId= userlist!!.get(1).uid
            val deletionReference= FirebaseDatabase.getInstance()
                .getReference().child("Users/$userId")
            //Set an alert when someone clicks
            val alertDialog= AlertDialog.Builder(context)
            alertDialog.setTitle("ALERT!!")
            alertDialog.setMessage("Select an option you want to perform")
            alertDialog.setNegativeButton("Update", DialogInterface.OnClickListener
            { dialogInterface, i ->
                //Dismiss the alert
            })

            alertDialog.setPositiveButton("Delete", DialogInterface.OnClickListener{
                    dialogInterface, i ->  deletionReference.removeValue()
                Toast.makeText(context,"Delete Sucessfully",
                    Toast.LENGTH_LONG).show()
            })
            alertDialog.create().show()





        }
    }

    override fun getItemCount(): Int {
        return userlist.size

    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName = itemView.findViewById<TextView>(R.id.mName)
        val textEmail = itemView.findViewById<TextView>(R.id.mEmail)
    }
}