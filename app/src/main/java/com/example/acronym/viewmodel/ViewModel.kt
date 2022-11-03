package com.example.acronym.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acronym.data.AbbreviationResponse
import com.example.acronym.repository.AbbreviationRepository
import com.example.acronym.util.Utils.isInternetAvailable

class SearchViewModel(private val context: Context) : ViewModel() {

    private var listData = MutableLiveData<List<AbbreviationResponse>>()

    fun init(shortForm: String){
        val abbreviationRepository : AbbreviationRepository by lazy {
            AbbreviationRepository
        }
        if(context.isInternetAvailable()) {
            listData = abbreviationRepository.getLiveData(context,shortForm)
        }
    }

    fun getData() : MutableLiveData<List<AbbreviationResponse>>{
        return listData
    }
}