package com.lovisgod.movemate.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.lovisgod.movemate.data.dataRepository.DataRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoveMateViewModel @Inject constructor(
  val dataRepo: DataRepo
): ViewModel() {

}