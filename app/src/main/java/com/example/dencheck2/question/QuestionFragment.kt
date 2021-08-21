package com.example.dencheck2.question

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.dencheck2.R
import com.example.dencheck2.databinding.FragmentQuestionBinding


class QuestionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentQuestionBinding>(inflater,
            R.layout.fragment_question, container, false)

        val args = QuestionFragmentArgs.fromBundle(requireArguments())

        binding.questionNextYes.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER") {view: View -> view.findNavController().navigate(QuestionFragmentDirections.actionQuestionFragmentToBubbleFragment(args.quoteText))}

        binding.questionNextNo.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){view: View -> view.findNavController().navigate(QuestionFragmentDirections.actionQuestionFragmentToWarFragment(args.quoteText))}

        return binding.root
    }

}