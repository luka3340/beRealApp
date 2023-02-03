package com.example.berealapp.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.berealapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var signUpText: TextView
    private lateinit var forgotPassText: TextView
    private lateinit var loginButton: Button

    private lateinit var emailInp: EditText
    private lateinit var passwordInp: EditText

    private var auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_login, container,false)
        signUpText = view.findViewById(R.id.SignUp)
        forgotPassText = view.findViewById(R.id.ForgotPass)
        loginButton = view.findViewById(R.id.LoginBtn)
        emailInp = view.findViewById(R.id.emailInp)
        passwordInp = view.findViewById(R.id.passwordInp)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (auth.currentUser != null) {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_contentFragment)
        }
        super.onViewCreated(view, savedInstanceState)
        registerListener(view)
    }

    private fun registerListener(view: View) {
        signUpText.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        forgotPassText.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        loginButton.setOnClickListener {
            val email = emailInp.text.toString()
            val password = passwordInp.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_contentFragment)
                    } else {
                        Toast.makeText(activity, "Login failed. ", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance() = LoginFragment()
    }

}