package com.example.berealapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.berealapp.PostItemData
//import com.example.berealapp.PostRecyclerAdapter
import com.example.berealapp.R
import com.example.berealapp.adapters.PostAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FeedFragment : Fragment(R.layout.fragment_feed) {

    private lateinit var recyclerView: RecyclerView
//    private lateinit var recycleAdapter: PostRecyclerAdapter
    private lateinit var addImageBtn: Button

    private var db = FirebaseDatabase.getInstance().getReference("images")
    private var auth = FirebaseAuth.getInstance()

    private lateinit var adapter: PostAdapter
    private lateinit var arrayOfPosts: ArrayList<PostItemData>

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed,container,false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        addImageBtn = view.findViewById(R.id.addImageBtn)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        loadData()
        registerListener(view)
    }

    private fun init() {
        arrayOfPosts = arrayListOf()
    }

    private fun loadData() {
        db.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    val currentPost = dataSnapshot.getValue(PostItemData::class.java)?: return
                    arrayOfPosts.add(currentPost)
                }
                recyclerView.adapter = PostAdapter(arrayOfPosts)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("tagg", "onCancelled")
            }

        })
    }

    private fun registerListener(view: View) {
        addImageBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_contentFragment_to_uploadImageFragment)
        }
    }
}