package com.shashank.qfonproject.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shashank.qfonproject.data.model.Aireways
import com.shashank.qfonproject.data.repository.AirWaysRepository
import com.shashank.qfonproject.utils.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AirwaysViewModel @Inject constructor(val repository: AirWaysRepository) :ViewModel(){

    val airWaysLiveData:LiveData<NetworkResponse<Aireways>>
        get() = repository.AirwaysLiveData


    fun  getAirwaysLiveData(page:Int ,size:Int){
        viewModelScope.launch {
            repository.getAirwaysList(page,size)
        }
    }
}