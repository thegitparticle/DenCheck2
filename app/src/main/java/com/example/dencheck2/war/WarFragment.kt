package com.example.dencheck2.war

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.dencheck2.R
import com.example.dencheck2.bubble.BubbleFragmentArgs
import com.example.dencheck2.databinding.FragmentWarBinding


class WarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentWarBinding>(inflater,
            R.layout.fragment_war, container, false)

        val args = WarFragmentArgs.fromBundle(requireArguments())

        binding.quoteText.text = args.quoteText

        binding.warGoHome.setOnClickListener{view: View -> view.findNavController().navigate(R.id.action_warFragment_to_quoteFragment)}

        return binding.root
    }


}