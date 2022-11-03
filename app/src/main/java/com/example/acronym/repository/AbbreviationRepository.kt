package com.example.acronym.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.acronym.data.AbbreviationResponse
import com.example.acronym.remote.ApiClient
import com.example.acronym.util.Utils.hideProgressBar
import com.example.acronym.util.Utils.showProgressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AbbreviationRepository {
    fun getLiveData(context: Context, shortForm: String) : MutableLiveData<List<AbbreviationResponse>> {

        val mutableLiveData = MutableLiveData<List<AbbreviationResponse>>()

        context.showProgressBar()

        ApiClient.apiService.getMeanings(shortForm).enqueue(object : Callback<List<AbbreviationResponse>> {
            override fun onFailure(call: Call<List<AbbreviationResponse>>, t: Throwable) {
                hideProgressBar()
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<List<AbbreviationResponse>>,
                response: Response<List<AbbreviationResponse>>
            ) {
                hideProgressBar()
                val usersResponse = response.body()
                usersResponse?.let { mutableLiveData.value = it }
            }

        })

        return mutableLiveData
    }
}