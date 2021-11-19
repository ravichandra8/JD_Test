package com.surendra.jd_test.viewmodel

import com.surendra.jd_test.model.RootResponse
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surendra.jd_test.repository.JDRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NavViewModel
@Inject
constructor(private val repository: JDRepository) : ViewModel() {

    private val _navResponse = MutableLiveData<RootResponse>()

    val responseNavData: LiveData<RootResponse>
        get() = _navResponse



    suspend fun getAllImages() {
         withContext(Dispatchers.IO) {
             repository.getNavData().let { response ->

                 if (response.isSuccessful) {
//                viewModelScope.launch(Dispatchers.Main) {
//                    _navResponse.value= response.body()
//                }
                     _navResponse.postValue(response.body())
                 } else {
                     Log.d(
                         "your tag",
                         "getAllImages Error: ${response.errorBody()}"
                     )
                 }
             }
         }

    }


}
























