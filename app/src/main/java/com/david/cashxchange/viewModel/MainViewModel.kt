package com.david.cashxchange.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.cashxchange.helper.Resource
import com.david.cashxchange.helper.SingleLiveEvent
import com.david.cashxchange.models.ApiResponse
import com.david.cashxchange.view.MainRepo
import kotlinx.coroutines.launch


class MainViewModel (private val mainRepo: MainRepo) : ViewModel()  {


    //cached
    private val _data = SingleLiveEvent<Resource<ApiResponse>>()


    //public
    val data  =  _data
    val convertedRate = MutableLiveData<Double>()


    //Public function to get the result of conversion
    fun getConvertedData(access_key: String, from: String, to: String, amount: Double) {
        viewModelScope.launch {
            mainRepo.getConvertedData(access_key, from, to, amount).collect {
                data.value = it
            }
        }
    }


}
