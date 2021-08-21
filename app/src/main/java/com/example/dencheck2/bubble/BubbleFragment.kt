package com.example.dencheck2.bubble

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.dencheck2.R
import com.example.dencheck2.databinding.FragmentBubbleBinding
import com.example.dencheck2.question.QuestionFragmentArgs


class BubbleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentBubbleBinding>(inflater,
            R.layout.fragment_bubble, container, false)

        val args = BubbleFragmentArgs.fromBundle(requireArguments())

        binding.quoteText.text = args.quoteText

        binding.bubbleGoHome.setOnClickListener{view: View -> view.findNavController().navigate(R.id.action_bubbleFragment_to_quoteFragment)}

        return binding.root
    }

}