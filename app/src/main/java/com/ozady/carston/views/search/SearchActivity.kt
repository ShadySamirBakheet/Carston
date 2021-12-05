package com.ozady.carston.views.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozady.carston.R
import com.ozady.carston.adapters.data.search.FilterPriceAdapter
import com.ozady.carston.adapters.data.search.FilterSearchAdapter
import com.ozady.carston.adapters.data.search.SearchAdapter
import com.ozady.carston.databinding.ActivitySearchBinding
import com.ozady.carston.views.cars.CarFavoriteActivity

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var filterSearchAdapter: FilterSearchAdapter

    var searchText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchText = intent.getStringExtra("searchText") ?: ""

        if (!searchText.isNullOrEmpty()){
            binding.search.setText(searchText)
            binding.searchCon.visibility = VISIBLE
        }

        binding.goSearch.setOnClickListener {
            if (binding.searchCon.visibility == VISIBLE){
                binding.searchCon.visibility = GONE
            }else{
                binding.searchCon.visibility = VISIBLE
            }
        }

        binding.filterList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SearchActivity,
                LinearLayoutManager.HORIZONTAL,false)

            filterSearchAdapter = FilterSearchAdapter(this@SearchActivity)
            adapter = filterSearchAdapter
        }

        binding.searchList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = SearchAdapter(this@SearchActivity, false)
        }

        filterSearchAdapter.setOnItemClickListener {
            getFilterRange()
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.filterBtn.setOnClickListener {
            startActivity(Intent(this,FilterActivity::class.java))
        }

        binding.goFav.setOnClickListener {
            startActivity(Intent(this, CarFavoriteActivity::class.java))
        }

    }


    private fun getFilterRange() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogLayout = inflater.inflate(R.layout.popup_filter, null)

        val filterPriceList = dialogLayout.findViewById<RecyclerView>(R.id.filterPriceList)

        filterPriceList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = FilterPriceAdapter(this@SearchActivity)
        }

        alertDialogBuilder.setView(dialogLayout)
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

}