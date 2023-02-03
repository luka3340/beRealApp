package com.example.berealapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.berealapp.R
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var auth = FirebaseAuth.getInstance()

    private lateinit var logOutBtn: Button
    private lateinit var changePasswordBtn: Button
    private lateinit var changeMailBtn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logOutBtn = view.findViewById(R.id.logOutBtn)
        changePasswordBtn = view.findViewById(R.id.changePasswordBtn)
        changeMailBtn = view.findViewById(R.id.changeEmailBtn)
        changeMailBtn.isEnabled = false
        registerListener(view)
    }

    private fun registerListener(view: View) {
        logOutBtn.setOnClickListener {
            auth.signOut()
            Navigation.findNavController(view).navigate(R.id.action_contentFragment_to_loginFragment)
        }
        changePasswordBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_contentFragment_to_changePasswordFragment)
        }
    }

}