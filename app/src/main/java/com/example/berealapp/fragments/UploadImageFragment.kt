package com.example.berealapp.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.berealapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlin.math.abs

class UploadImageFragment: Fragment(R.layout.fragment_upload_image) {

    private lateinit var storageRef: StorageReference
//    private lateinit var databaseRef: DatabaseReference
    private var db = FirebaseDatabase.getInstance().getReference("images")
    private var auth = FirebaseAuth.getInstance()

    private lateinit var uploadImageBtn: LinearLayout
    private lateinit var imageView: ImageView
    private lateinit var publishBtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uploadImageBtn = view.findViewById(R.id.uploadImageBtn)
        publishBtn = view.findViewById(R.id.publishBtn)
        imageView = view.findViewById(R.id.imageView)

        storageRef = Firebase.storage.reference
//        databaseRef = Firebase.database.reference

        registerListener()
    }

    private fun registerListener() {
        uploadImageBtn.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK)
            // here item is type of image
            galleryIntent.type = "image/*"
            // ActivityResultLauncher callback
            imagePickerActivityResult.launch(galleryIntent)
        }
    }

    // For upload image

    private var imagePickerActivityResult: ActivityResultLauncher<Intent> =
        registerForActivityResult( ActivityResultContracts.StartActivityForResult()) { result ->
            if (result != null) {
                val imageUri: Uri? = result.data?.data


                val sd = getFileName(requireContext().applicationContext, imageUri!!)
                Log.d("tagg", sd.toString())

                val uploadTask = storageRef.child("file/$sd").putFile(imageUri)

                uploadTask.addOnSuccessListener {
                    storageRef.child("file/$sd").downloadUrl.addOnSuccessListener { url ->

                        Log.d("tagg", "------")
                        Log.d("tagg", url.toString())

                        //

                        val id = db.push().key.toString()

                        db.child(id).child("author").setValue(auth.currentUser!!.uid)
                        db.child(id).child("url").setValue(url.toString()).addOnCompleteListener { task ->
                            Log.d("tagg", "complete")
                            if (task.isSuccessful) {
                                Log.d("tagg", "Success")
                            } else {
                                Log.d("tagg", "failed")
                                Log.d("tagg", task.exception!!.message.toString())
                            }
                        }

//                        db.child(auth.currentUser!!.uid).push().child("url").setValue(url.toString()).addOnCompleteListener { task ->
//                            Log.d("tagg", "complete")
//                            if (task.isSuccessful) {
//                                Log.d("tagg", "Success")
//                            } else {
//                                Log.d("tagg", "failed")
//                                Log.d("tagg", task.exception!!.message.toString())
//                            }
//                        }

                        //

                        Glide.with(requireActivity())
                            .load(url)
                            .into(imageView)

                        Log.e("Firebase", "download passed")
                    }.addOnFailureListener {
                        Log.e("Firebase", "Failed in downloading")
                    }
                }.addOnFailureListener {
                    Log.e("Firebase", "Image Upload fail")
                }
            }
        }

    private fun getFileName(context: Context, uri: Uri): String? {
        if (uri.scheme == "content") {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            cursor.use {
                if (cursor != null && cursor.moveToFirst()) {
                    return cursor.getString(abs(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)))
                }
            }
        }
        return uri.path?.lastIndexOf('/')?.let { uri.path?.substring(it) }
    }

}