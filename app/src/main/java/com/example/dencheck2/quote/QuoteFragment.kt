package com.example.dencheck2.quote

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.dencheck2.R
import com.example.dencheck2.databinding.FragmentQuoteBinding


class QuoteFragment : Fragment() {

    private lateinit var viewModel: QuoteFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentQuoteBinding>(
            inflater,
            R.layout.fragment_quote,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(QuoteFragmentViewModel::class.java)
        binding.quoteFragmentModel = viewModel


        val quoteText: String = binding.quoteText.text as String

        viewModel.userName.observe(viewLifecycleOwner, Observer { newName ->
            binding.userDetailsName.text = newName.toString()
        })


        binding.quoteNext.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER") { view: View ->
            view.findNavController()
                .navigate(QuoteFragmentDirections.actionQuoteFragmentToQuestionFragment(quoteText))
        }

        return binding.root

    }

    override fun onStart() {
        super.onStart()
        Log.i("QuoteFragment", "onStart Called")
    }

}


