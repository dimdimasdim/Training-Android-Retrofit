package com.dimas.networkexercise.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimas.networkexercise.base.AppModule
import com.dimas.networkexercise.presentation.adapter.MovieAdapter
import com.dimas.networkexercise.databinding.FragmentHomeBinding
import com.dimas.networkexercise.domain.model.Movie
import com.dimas.networkexercise.presentation.viewmodel.HomeViewModel
import com.dimas.networkexercise.utils.Error
import com.dimas.networkexercise.utils.Initiate
import com.dimas.networkexercise.utils.Loading
import com.dimas.networkexercise.utils.Success
import com.dimas.networkexercise.utils.observeIn

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    private var adapter: MovieAdapter? = null

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            binding?.apply {
                if (adapter == null) adapter = MovieAdapter(it, mutableListOf())
                listMovie.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = this@HomeFragment.adapter
                }

                swpHome.setOnRefreshListener {
                    swpHome.isRefreshing = false
                }
            }
        }

    }

    private fun showLoader(isLoading: Boolean) {
        binding?.apply {
            pbHome.isVisible = isLoading
            listMovie.isVisible = !isLoading
        }
    }

    private fun showListMovie(data: List<Movie>) {
        adapter?.addAll(data)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}