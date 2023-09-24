package com.android_a865.captainhelper.feature_home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_a865.captainhelper.R
import com.android_a865.captainhelper.adapters.DaysAdapter
import com.android_a865.captainhelper.databinding.FragmentHomeBinding
import com.android_a865.captainhelper.feature_home.data.DayEntity
import com.android_a865.captainhelper.utils.exhaustive
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : Fragment(R.layout.fragment_home),
DaysAdapter.OnItemEventListener{

    private val daysAdapter = DaysAdapter(this)
    private val viewModel by viewModels<HomeViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHomeBinding.bind(view)

        binding.apply {

            daysList.apply {
                adapter = daysAdapter
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
            }

            fab.setOnClickListener {
                viewModel.onFabClicked()
            }


        }


        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.windowEvents.collect { event ->
                when (event) {
                    is HomeViewModel.WindowEvents.Navigate -> {
                        findNavController().navigate(event.direction)
                    }
                }.exhaustive
            }
        }

        viewModel.days.asLiveData().observe(viewLifecycleOwner) {
            daysAdapter.submitList(it)
        }




    }

    override fun onItemClicked(day: DayEntity) {
        viewModel.onItemClicked(day)
    }

}