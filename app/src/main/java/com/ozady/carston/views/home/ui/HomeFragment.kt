package com.ozady.carston.views.home.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.home.BodyCarAdapter
import com.ozady.carston.adapters.data.home.ExpertReviewsAdapter
import com.ozady.carston.adapters.data.home.BrandAdapter
import com.ozady.carston.adapters.data.home.PopularCarAdapter
import com.ozady.carston.adapters.data.news.NewsHomeAdapter
import com.ozady.carston.adapters.data.videos.VideosAdapter
import com.ozady.carston.adapters.slider.SliderHomeAdapter
import com.ozady.carston.databinding.FragmentHomeBinding
import com.ozady.carston.views.cars.NewCarsActivity
import com.ozady.carston.views.cars.ViewBodyCarsActivity
import com.ozady.carston.views.cars.ExpertReviewsListActivity
import com.ozady.carston.views.create_listing.CreateListingStepOneActivity
import com.ozady.carston.views.news_reviews.NewsAndReviewsActivity
import com.ozady.carston.views.search.SearchActivity
import com.ozady.carston.views.videos.VideosActivity
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.imageSlider.apply {
            setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
            setSliderAnimationDuration(1000)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            scrollTimeInSec = 4 //set scroll delay in seconds :
            startAutoCycle()
            setSliderAdapter(SliderHomeAdapter(context))
        }

        binding.popularList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = PopularCarAdapter(context)
        }

        binding.topList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = PopularCarAdapter(context)
        }

        binding.videoList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = VideosAdapter(context)
        }

        binding.goSearch.setOnClickListener {
            startActivity(Intent(context, SearchActivity::class.java))
        }

        binding.goNewCar.setOnClickListener {
            startActivity(Intent(context, NewCarsActivity::class.java))
        }

        binding.btnBody.setOnClickListener {
            startActivity(Intent(context, ViewBodyCarsActivity::class.java))
        }

        binding.goUsedCar.setOnClickListener {
            startActivity(Intent(context, NewCarsActivity::class.java))
        }

        binding.btnCreatePayCar.setOnClickListener {
            startActivity(Intent(context, CreateListingStepOneActivity::class.java))
        }

        binding.btnExpert.setOnClickListener {
            startActivity(Intent(context, ExpertReviewsListActivity::class.java))
        }

        binding.videosCon.setOnClickListener {
            startActivity(Intent(context, VideosActivity::class.java))
        }

        binding.newsCon.setOnClickListener {
            startActivity(Intent(context, NewsAndReviewsActivity::class.java))
        }

        binding.btnSearch.setOnClickListener {
            if (!binding.search.text.toString().trim().isNullOrEmpty()){
                startActivity(Intent(context, SearchActivity::class.java).putExtra("searchText",binding.search.text.toString().trim()))
            }else{
                startActivity(Intent(context,SearchActivity::class.java))
            }
        }

        binding.newsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = NewsHomeAdapter(context)
        }

        binding.expertList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = ExpertReviewsAdapter(context)
        }

        binding.bodyCarList.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,3)
            adapter = BodyCarAdapter(context, true, false)
        }

        binding.brandList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = BrandAdapter(context, true)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.conMain.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (scrollY >= oldScrollY || scrollY > 0) {
                    if (scrollY > 0){
                        binding.toolbar.alpha = (scrollY.toFloat()/500f)
                    }
                } else {
                    binding.toolbar.alpha = 0f
                }
            }
        }else{
            binding.toolbar.alpha = 1f
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}