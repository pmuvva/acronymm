package com.example.acronym.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.acronym.R
import com.example.acronym.viewmodel.SearchViewModel
import com.example.acronym.adapter.AbbreviationAdapter
import com.example.acronym.databinding.ActivityMainBinding
import com.example.acronym.remote.SearchViewModelFactory
import com.example.acronym.util.Utils
import com.example.acronym.util.Utils.showErrorToast


class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityMainBinding
    private val adapter = AbbreviationAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //data binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener(this)
    }

    private fun searchData(){

        if(binding.etSearch.text.isNotEmpty()){
            val searchViewModel = ViewModelProviders.of(this,
                SearchViewModelFactory(this@MainActivity)
            ).get(SearchViewModel::class.java)

            // setup list adapter
            binding.rvMeanings.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvMeanings.adapter = adapter

            // get search data
            searchViewModel.init(binding.etSearch.text.toString())
            searchViewModel.getData().observe(this) { response ->
                response?.let {
                    if(response.isNotEmpty()) {
                        binding.rvMeanings.visibility = View.VISIBLE
                        binding.tvNoData.visibility = View.GONE
                        adapter.setSearchList(it[0].lfs)
                        adapter.notifyDataSetChanged()
                    } else {
                        binding.rvMeanings.visibility = View.GONE
                        binding.tvNoData.visibility = View.VISIBLE
                    }

                    Log.i("response", response.toString())
                }
            }
        } else {
            showErrorToast("Please enter search text")
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_search){
            Utils.hideKeyboard(binding.btnSearch, this)
            searchData()
        }
    }
}