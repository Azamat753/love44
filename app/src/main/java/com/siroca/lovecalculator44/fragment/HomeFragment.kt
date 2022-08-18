package com.siroca.lovecalculator44.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.siroca.lovecalculator44.LoveViewModel
import com.siroca.lovecalculator44.Utils
import com.siroca.lovecalculator44.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    var a = "asdas"
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var utils: Utils

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            okBtn.setOnClickListener {
                viewModel.getLiveLoveModel(
                    firstNameEd.text.toString(),
                    secondNameEd.text.toString()
                ).observe(viewLifecycleOwner) {
                    utils.showToast(requireContext(), it.result)
                    okBtn.text = it.result
                }
            }
        }
    }
}