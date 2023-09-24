package com.android_a865.captainhelper.feature_home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.android_a865.captainhelper.feature_home.data.DayEntity
import com.android_a865.captainhelper.feature_home.data.DaysRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: DaysRepository
): ViewModel() {


    val days = repository.getDays()

    private val eventsChannel = Channel<WindowEvents>()
    val windowEvents = eventsChannel.receiveAsFlow()

    fun onFabClicked() = viewModelScope.launch {
        eventsChannel.send(
            WindowEvents.Navigate(
                HomeDirections.actionHome3ToAddDayFragment()
            )
        )
    }

    fun onItemClicked(day: DayEntity) = viewModelScope.launch {
        eventsChannel.send(
            WindowEvents.Navigate(
                HomeDirections.actionHome3ToAddDayFragment(
                    day
                )
            )
        )
    }


    sealed class WindowEvents {
        data class Navigate(val direction: NavDirections) : WindowEvents()
    }

}