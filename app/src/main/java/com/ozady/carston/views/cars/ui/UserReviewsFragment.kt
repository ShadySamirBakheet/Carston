package com.ozady.carston.views.cars.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozady.carston.adapters.data.cars.TypeReviewCarAdapter
import com.ozady.carston.adapters.data.cars.UserReviewCarAdapter
import com.ozady.carston.databinding.FragmentUserReviewsBinding
import com.ozady.carston.views.news_reviews.AddCarReviewsActivity
import com.ozady.carston.views.news_reviews.NewsAndReviewsActivity

class UserReviewsFragment : Fragment() {

    private var _binding: FragmentUserReviewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUserReviewsBinding.inflate(inflater, container, false)

        binding.userReviewList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = UserReviewCarAdapter(context)
        }

        binding.reviewTypeList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = TypeReviewCarAdapter(context)
        }

        ///AddCarReviewsActivity
        binding.addComment.setOnClickListener {
            startActivity(Intent(context, AddCarReviewsActivity::class.java))
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}