package com.lovisgod.movemate.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lovisgod.movemate.data.dataRepository.DataRepo
import com.lovisgod.movemate.data.model.FreightOption
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MoveMateViewModel @Inject constructor(
  val dataRepo: DataRepo
): ViewModel() {


  private val _freightOptionsState = MutableStateFlow(listOf<FreightOption>())
  val freightOptionsState = _freightOptionsState.asStateFlow()


  fun getFreightOptions() {
    viewModelScope.launch {
      withContext(Dispatchers.IO) {
        val options = dataRepo.getFreightOptions()
        _freightOptionsState.emit(options)
      }
    }
  }
}