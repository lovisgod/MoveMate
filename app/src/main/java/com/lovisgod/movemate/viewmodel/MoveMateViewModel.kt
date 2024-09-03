package com.lovisgod.movemate.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lovisgod.movemate.data.dataRepository.DataRepo
import com.lovisgod.movemate.data.model.FreightOption
import com.lovisgod.movemate.data.model.ShipmentItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.time.Duration

@HiltViewModel
class MoveMateViewModel @Inject constructor(
  val dataRepo: DataRepo
): ViewModel() {


  private val _freightOptionsState = MutableStateFlow(listOf<FreightOption>())
  val freightOptionsState = _freightOptionsState.asStateFlow()

  private val _shipmentsState = MutableStateFlow(listOf<ShipmentItem>())
  val shipmentsState = _shipmentsState.asStateFlow()


  fun getFreightOptions() {
    viewModelScope.launch {
      withContext(Dispatchers.IO) {
        val options = dataRepo.getFreightOptions()
        _freightOptionsState.emit(options)
      }
    }
  }

  fun getShipments(){
    viewModelScope.launch {
      withContext(Dispatchers.IO) {
        _shipmentsState.emit(listOf())
        // simulate network calls
        delay(400)
        val options = dataRepo.getShipments()
        _shipmentsState.emit(options)
      }
    }
  }
}