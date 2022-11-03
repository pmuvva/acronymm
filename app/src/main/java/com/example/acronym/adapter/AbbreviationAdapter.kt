package com.example.acronym.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.acronym.R
import com.example.acronym.data.LongFormDetails

class AbbreviationAdapter : RecyclerView.Adapter<AbbreviationAdapter.ViewHolder>() {

    private var longFormList = emptyList<LongFormDetails>()

    internal fun setSearchList(longFormList: List<LongFormDetails>) {
        this.longFormList = longFormList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var searchItem: TextView

        init {
            searchItem = itemView.findViewById(R.id.tv_abbreviation)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Inflate the custom layout
        var view = LayoutInflater.from(parent.context).
        inflate(R.layout.layout_abbreviation_list_item, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var data = longFormList[position]
        holder.searchItem.text = data.lf
    }

    override fun getItemCount() = longFormList.size
}
