package com.novopay.navipullrequestassignment.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.novopay.navipullrequestassignment.R
import com.novopay.navipullrequestassignment.data.PullRequestResponse
import com.novopay.navipullrequestassignment.data.Resource
import com.novopay.navipullrequestassignment.data.Status
import com.novopay.navipullrequestassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: PullRequestVM

    private val adapter by lazy { ClosePullRequestAdapter(this) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViews()
        viewModel.getClosePullRequest()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.getPullRequestLiveData.observe(this) {
            it?.let {
                handlePullRequestData(it)
            }
        }
    }

    private fun handlePullRequestData(data: Resource<List<PullRequestResponse>>) {
        when (data.status) {
            Status.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            Status.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
                adapter.setList(data.data as ArrayList<PullRequestResponse>)
            }
            Status.ERROR -> {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this, data.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initViews() {
        setAdapter()
    }

    private fun setAdapter() {
        with(binding) {
            rvPullRequest.adapter = adapter
        }
    }
}