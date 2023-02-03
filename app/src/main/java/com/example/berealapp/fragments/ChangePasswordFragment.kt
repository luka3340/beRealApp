package com.example.berealapp.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.berealapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException

class ChangePasswordFragment : Fragment(R.layout.fragment_change_password) {

    private var auth = FirebaseAuth.getInstance()

    private lateinit var newPasswordInp: EditText
    private lateinit var confirmNewPasswordInp: EditText
    private lateinit var changePasswordBtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newPasswordInp = view.findViewById(R.id.newPasswordInp)
        confirmNewPasswordInp = view.findViewById(R.id.confirmNewPasswordInp)
        changePasswordBtn = view.findViewById(R.id.changePasswordBtn)
        registerListener(view)
    }

    private fun registerListener(view: View) {
        changePasswordBtn.setOnClickListener {

            val newPassword = newPasswordInp.text.toString()
            val newPasswordConfirm = confirmNewPasswordInp.text.toString()

            if (newPassword.trim() != newPasswordConfirm.trim()) {
                Toast.makeText(activity, "Confirm password failed.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(newPassword.isNotEmpty() && newPassword == newPasswordConfirm){
                auth.currentUser!!.updatePassword(newPassword).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(activity, "Password changed.", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(view).navigate(R.id.action_changePasswordFragment_to_contentFragment)
                    } else {
                        try {
                            throw task.exception!!
                        } catch (e: FirebaseAuthRecentLoginRequiredException) {
                            Toast.makeText(activity, "Please re-login and try again.", Toast.LENGTH_SHORT).show()
                        } catch (e: java.lang.Exception) {
                            Toast.makeText(activity, "Change Password failed.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        }
    }

}