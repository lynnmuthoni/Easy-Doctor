package com.example.easydoc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.easydoc.databinding.ActivityDoctorHomeActivtyBinding
import com.google.firebase.auth.FirebaseAuth

class DoctorHomeActivty : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDoctorHomeActivtyBinding
    private lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth= FirebaseAuth.getInstance()

        binding = ActivityDoctorHomeActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarDoctorHomeActivty.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_doctor_home_activty)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_emergency, R.id.nav_appointment,R.id.nav_logout,R.id.nav_location
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.doctor_home_activty, menu)
        return super.onCreateOptionsMenu(menu)}

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when(item.itemId ){
                R.id.action_logout->{
                    firebaseAuth.signOut()
                    finish()
                    return true
                }
                R.id.action_mpesa->{
                    //Cos=de for toolkit

                    val simToolKitLaunchIntent =
                        applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                    simToolKitLaunchIntent?.let { startActivity(it) }
                    return true
                }
                R.id.action_SMS->{

                    //SMS
                    val uri = Uri.parse("smsto:YOUR_SMS_NUMBER")
                    val intent = Intent(Intent.ACTION_SENDTO, uri)
                    intent.putExtra("sms_body", "The SMS text")
                    startActivity(intent)

                    return true
                }
                R.id.action_settings->{
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
                    startActivity(shareIntent)
                    return true
                }
            }




            return true
        }





    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_doctor_home_activty)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}