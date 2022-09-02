package com.example.easydoc.ui.gallery

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easydoc.DermatologistActivity
import com.example.easydoc.databinding.FragmentGalleryBinding
import com.example.easydoc.databinding.FragmentHomeBinding

class GalleryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ? {
        val bind = FragmentGalleryBinding.inflate(layoutInflater)
        bind.mBtnCall.setOnClickListener {




            }




        return bind.root
    }


    }
