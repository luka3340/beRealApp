package com.example.berealapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.berealapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {

    private lateinit var logInText: TextView
    private lateinit var signUpText: TextView
    private lateinit var resetPasswordBtn: Button
    private lateinit var emailInp: EditText

    private var auth = FirebaseAuth.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_forgot_password, container,false)
        logInText = view.findViewById(R.id.logInTxt)
        signUpText = view.findViewById(R.id.SignUpTxt)
        resetPasswordBtn = view.findViewById(R.id.resetBtn)
        emailInp = view.findViewById(R.id.emailInp)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerListener(view)
    }

    private fun registerListener(view: View) {
        logInText.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_forgotPasswordFragment_to_loginFragment)
        }

        signUpText.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_forgotPasswordFragment_to_signUpFragment)
        }

        resetPasswordBtn.setOnClickListener {
            val email = emailInp.text.toString()
            if (email.isNotEmpty()){
                auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(activity, "Check email.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(activity, "Can't reset password.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}