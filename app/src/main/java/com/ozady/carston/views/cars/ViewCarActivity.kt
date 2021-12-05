package com.ozady.carston.views.cars

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ozady.carston.adapters.TabsAdapter.CarViewTabAdapter
import com.ozady.carston.databinding.ActivityViewCarBinding
import com.ozady.carston.views.cars.ui.*
import com.ozady.carston.views.notifications.NotificationsListActivity
import com.ozady.carston.views.search.SearchActivity


class ViewCarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewCarBinding

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    var tabNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabNum = intent.getIntExtra("tabNum",0)

        binding.goSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

        viewPager = binding.viewPager
        tabLayout = binding.tabsCar
        val carViewTabAdapter = CarViewTabAdapter(supportFragmentManager)

        carViewTabAdapter.addFragment(CarViewFragment(),"View")
        carViewTabAdapter.addFragment(VariantsFragment(),"Variants")
        carViewTabAdapter.addFragment(GalleryFragment(),"Gallery")
        carViewTabAdapter.addFragment(SpecsFeaturesFragment(),"Specs & Features")
        carViewTabAdapter.addFragment(UserReviewsFragment(),"User Reviews")
        carViewTabAdapter.addFragment(MoreCarFragment(),"More")

        viewPager.setAdapter(carViewTabAdapter)
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.selectTab(tabLayout.getTabAt(tabNum))
    }
}