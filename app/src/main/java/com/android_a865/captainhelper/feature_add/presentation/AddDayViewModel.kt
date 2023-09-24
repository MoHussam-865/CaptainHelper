package com.android_a865.captainhelper.feature_add.presentation

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.android_a865.captainhelper.feature_home.data.DayEntity
import com.android_a865.captainhelper.feature_home.data.DaysRepository
import com.android_a865.captainhelper.feature_home.presentation.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddDayViewModel @Inject constructor(
    state: SavedStateHandle,
    private val repository: DaysRepository
): ViewModel() {

    val day = state.get<DayEntity>("day")

    private val eventsChannel = Channel<WindowEvents>()
    val windowEvents = eventsChannel.receiveAsFlow()


    @SuppressLint("ShowToast")
    fun onFabClicked(
        context: Context,
        km: Int?,
        made: Int?
    ) = viewModelScope.launch {

        if (km != null && made != null){
            var done = false

            AlertDialog.Builder(context)
                .setMessage("Save Forever")
                .setPositiveButton("yes") { d, _ ->
                    done = true
                    d.dismiss()
                }.setNegativeButton("no") { d, _ ->
                    d.dismiss()
                }.show()


            repository.insertDay(km, made, done)
            eventsChannel.send(
                WindowEvents.GoBack
            )
        } else {
            Toast.makeText(context,"Enter Data First", Toast.LENGTH_LONG)
        }
    }


    sealed class WindowEvents {
        object GoBack: WindowEvents()
    }
}