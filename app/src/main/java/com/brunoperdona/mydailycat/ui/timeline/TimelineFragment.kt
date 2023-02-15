package com.brunoperdona.mydailycat.ui.timeline

import android.os.Bundle
import android.text.format.Time
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.brunoperdona.mydailycat.databinding.FragmentTimelineBinding

class TimelineFragment : Fragment() {

    private var _binding: FragmentTimelineBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TimelineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TimelineAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTimelineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dailyRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.dailyRecyclerView.adapter = adapter

        binding.optionsButton.setOnClickListener{
            adapter.addDaily(DailyItem("02, Favereiro de 2020", "Testando", 1))
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}