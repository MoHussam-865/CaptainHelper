package com.android_a865.captainhelper.feature_add.presentation

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android_a865.captainhelper.R
import com.android_a865.captainhelper.databinding.AdapterDayViewBinding
import com.android_a865.captainhelper.databinding.FragmentAddDayBinding
import com.android_a865.captainhelper.feature_home.presentation.HomeViewModel
import com.android_a865.captainhelper.utils.exhaustive
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddDayFragment : Fragment(R.layout.fragment_add_day) {

    private val viewModel by viewModels<AddDayViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAddDayBinding.bind(view)

        binding.apply {
            moneyMade.editText?.setText(viewModel.day?.made.toString())

            kmTraveled.editText?.setText(viewModel.day?.km.toString())

            fab.setOnClickListener {
                viewModel.onFabClicked(
                    requireContext(),
                    moneyMade.editText?.text.toString().toInt(),
                    kmTraveled.editText?.text.toString().toInt()
                )
            }

        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.windowEvents.collect { event ->
                when (event) {
                    is AddDayViewModel.WindowEvents.GoBack -> {
                        findNavController().popBackStack()
                    }
                }.exhaustive
            }
        }



    }
}