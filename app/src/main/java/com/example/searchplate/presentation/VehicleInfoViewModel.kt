package com.example.searchplate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchplate.data.VinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleInfoViewModel @Inject constructor(
    private val repository: VinRepository,
): ViewModel() {

    private val _vehicleInfoState = MutableStateFlow(VehicleInfoState())
    val vehicleInfoState: StateFlow<VehicleInfoState> by lazy {
        _vehicleInfoState
    }

    private fun getVehicleInfoByPlate(plate: String) {
        viewModelScope.launch {
            repository.getVehicleInfoByPlate(plate = plate)
                .onSuccess { info ->
                    _vehicleInfoState.update {
                        it.copy(info = info, isLoading = false, hasError = false)
                    }
                }
                .onFailure {ex ->
                    _vehicleInfoState.update {
                        it.copy(isLoading = false, hasError = true, error = ex)
                    }
                }
        }
    }
    fun onQueryChange(
        query: String
    ){
        _vehicleInfoState.update{
            it.copy(searchQuery = query)
        }
    }
    fun onSearch(plate: String) {
       getVehicleInfoByPlate(plate)
    }
}