package com.example.acronym.remote

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.acronym.viewmodel.SearchViewModel

class SearchViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(context) as T
    }
}