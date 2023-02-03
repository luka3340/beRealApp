package com.example.berealapp.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.berealapp.R
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private lateinit var termsAndConditionsText: TextView
    private lateinit var logInText: TextView
    private lateinit var checkBoxElem: CheckBox

    private lateinit var emailInp: EditText
    private lateinit var passwordInp: EditText
    private lateinit var confirmPasswordInp: EditText
    private lateinit var signupBtn: Button

    private var auth = FirebaseAuth.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_sign_up, container,false)
        logInText = view.findViewById(R.id.logInTextView)
        termsAndConditionsText = view.findViewById(R.id.TermsAndConditionsTxt)
        checkBoxElem = view.findViewById(R.id.checkBoxTermsAndConditions)

        emailInp = view.findViewById(R.id.emailInp)
        passwordInp = view.findViewById(R.id.passwordInp)
        confirmPasswordInp = view.findViewById(R.id.confirmPasswordInp)
        signupBtn = view.findViewById(R.id.signupBtn)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerListener(view)
    }

    private fun registerListener(view: View) {
        logInText.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        termsAndConditionsText.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_termsAndConditionsFragment)
        }

        signupBtn.setOnClickListener {

            val email = emailInp.text.toString()
            val password = passwordInp.text.toString()
            val confirmPassword = confirmPasswordInp.text.toString()

            if (password.trim() != confirmPassword.trim()) {
                Toast.makeText(activity, "Confirm password failed.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

           if(email.isNotEmpty() && password.isNotEmpty() && password==confirmPassword && checkBoxElem.isChecked){
               auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->

                   if (task.isSuccessful) {
                       Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_contentFragment)
                   } else {
                       Toast.makeText(activity, "Sign up failed.", Toast.LENGTH_SHORT).show()
                       Log.d("tagg", task.exception?.message.toString())
                   }

               }
           }

        }
    }

}