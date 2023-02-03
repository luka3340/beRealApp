package com.example.berealapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation

class TermsAndConditionsFragment : Fragment(R.layout.fragment_terms_and_conditions) {

    private lateinit var textViewTerm1: TextView
    private lateinit var textViewTerm2: TextView
    private lateinit var textViewTerm3: TextView
    private lateinit var textViewTerm4: TextView
    private lateinit var textViewTerm5: TextView
    private lateinit var textViewTerm6: TextView
    private lateinit var textViewTerm7: TextView
    private lateinit var textViewTerm8: TextView
    private lateinit var textViewTerm9: TextView
    private lateinit var textViewTerm10: TextView
    private lateinit var textViewTerm11: TextView
    private lateinit var textViewTerm12: TextView
    private lateinit var textViewTerm13: TextView
    private lateinit var textViewTerm14: TextView
    private lateinit var textViewTerm15: TextView
    private lateinit var textViewTerm16: TextView
    private lateinit var textViewTerm17: TextView
    private lateinit var textViewTerm18: TextView
    private lateinit var textViewTerm19: TextView
    private lateinit var textViewTerm20: TextView
    private lateinit var textViewTerm21: TextView
    private lateinit var textViewTerm22: TextView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewTerm1 = view.findViewById(R.id.term1)
        textViewTerm2 = view.findViewById(R.id.term2)
        textViewTerm3 = view.findViewById(R.id.term3)
        textViewTerm4 = view.findViewById(R.id.term4)
        textViewTerm5 = view.findViewById(R.id.term5)
        textViewTerm6 = view.findViewById(R.id.term6)
        textViewTerm7 = view.findViewById(R.id.term7)
        textViewTerm8 = view.findViewById(R.id.term8)
        textViewTerm9 = view.findViewById(R.id.term9)
        textViewTerm10 = view.findViewById(R.id.term10)
        textViewTerm11 = view.findViewById(R.id.term11)
        textViewTerm12 = view.findViewById(R.id.term12)
        textViewTerm13 = view.findViewById(R.id.term13)
        textViewTerm14 = view.findViewById(R.id.term14)
        textViewTerm15 = view.findViewById(R.id.term15)
        textViewTerm16 = view.findViewById(R.id.term16)
        textViewTerm17 = view.findViewById(R.id.term17)
        textViewTerm18 = view.findViewById(R.id.term18)
        textViewTerm19 = view.findViewById(R.id.term19)
        textViewTerm20 = view.findViewById(R.id.term20)
        textViewTerm21 = view.findViewById(R.id.term21)
        textViewTerm22 = view.findViewById(R.id.term22)
        registerListener(view)
    }

    private fun registerListener(view: View) {
        textViewTerm1.setOnClickListener {
            val bundle = bundleOf("term" to "term1")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm2.setOnClickListener {
            val bundle = bundleOf("term" to "term2")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm3.setOnClickListener {
            val bundle = bundleOf("term" to "term3")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm4.setOnClickListener {
            val bundle = bundleOf("term" to "term4")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm5.setOnClickListener {
            val bundle = bundleOf("term" to "term5")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm6.setOnClickListener {
            val bundle = bundleOf("term" to "term6")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm7.setOnClickListener {
            val bundle = bundleOf("term" to "term7")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm8.setOnClickListener {
            val bundle = bundleOf("term" to "term8")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm9.setOnClickListener {
            val bundle = bundleOf("term" to "term9")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm10.setOnClickListener {
            val bundle = bundleOf("term" to "term10")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm11.setOnClickListener {
            val bundle = bundleOf("term" to "term11")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm12.setOnClickListener {
            val bundle = bundleOf("term" to "term12")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm13.setOnClickListener {
            val bundle = bundleOf("term" to "term13")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm14.setOnClickListener {
            val bundle = bundleOf("term" to "term14")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm15.setOnClickListener {
            val bundle = bundleOf("term" to "term15")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm16.setOnClickListener {
            val bundle = bundleOf("term" to "term16")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm17.setOnClickListener {
            val bundle = bundleOf("term" to "term17")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm18.setOnClickListener {
            val bundle = bundleOf("term" to "term18")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm19.setOnClickListener {
            val bundle = bundleOf("term" to "term19")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm20.setOnClickListener {
            val bundle = bundleOf("term" to "term20")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm21.setOnClickListener {
            val bundle = bundleOf("term" to "term21")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
        textViewTerm22.setOnClickListener {
            val bundle = bundleOf("term" to "term22")
            Navigation.findNavController(view).navigate(R.id.action_termsAndConditionsFragment_to_termsDetailsFragment, bundle)
        }
    }

}