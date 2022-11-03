package com.example.acronym.remote

import com.example.acronym.data.AbbreviationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("software/acromine/dictionary.py")
    fun getMeanings(@Query("sf") shortForm: String): Call<List<AbbreviationResponse>>
}