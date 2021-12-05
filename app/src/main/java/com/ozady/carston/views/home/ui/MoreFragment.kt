package com.ozady.carston.views.home.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozady.carston.databinding.FragmentMoreBinding
import com.ozady.carston.views.cars.NewCarsActivity
import com.ozady.carston.views.cars.CompareListActivity
import com.ozady.carston.views.create_listing.CreateListingStepOneActivity
import com.ozady.carston.views.login_system.UserUpdateActivity
import com.ozady.carston.views.news_reviews.NewsAndReviewsActivity
import com.ozady.carston.views.rental.RentalCarActivity
import com.ozady.carston.views.settings.AppSettingsActivity
import com.ozady.carston.views.settings.ContactSupportActivity
import com.ozady.carston.views.settings.RatingAppActivity

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.profileCon.setOnClickListener {
            startActivity(Intent(context, UserUpdateActivity::class.java))
        }

        binding.supportCon.setOnClickListener {
            startActivity(Intent(context, ContactSupportActivity::class.java))
        }

        binding.carRentalCon.setOnClickListener {
            startActivity(Intent(context, RentalCarActivity::class.java))
        }

        binding.newCarCon.setOnClickListener {
            startActivity(Intent(context, NewCarsActivity::class.java))
        }

        binding.rateCon.setOnClickListener {
            startActivity(Intent(context, RatingAppActivity::class.java))
        }

        binding.usedCarCon.setOnClickListener {
            startActivity(Intent(context, NewCarsActivity::class.java))
        }

        binding.financingCon.setOnClickListener {
            startActivity(Intent(context, CreateListingStepOneActivity::class.java))
        }

        binding.compareCon.setOnClickListener {
            startActivity(Intent(context, CompareListActivity::class.java))
        }

        binding.sellCarCon.setOnClickListener {
            startActivity(Intent(context, CreateListingStepOneActivity::class.java))
        }

        binding.otherCon.setOnClickListener {
            startActivity(Intent(context, AppSettingsActivity::class.java))
        }

        binding.newsCon.setOnClickListener {
            startActivity(Intent(context, NewsAndReviewsActivity::class.java))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}