package com.gdg.boss.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gdg.boss.JobData
import com.gdg.boss.R
import com.gdg.boss.databinding.FragmentHomeBinding
import com.gdg.boss.databinding.ItemFindJobBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var jobListAdapter: JobListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding =
            FragmentHomeBinding.inflate(
                inflater,
                container,
                false,
            )

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initJobListRecyclerView(binding.rvFindJobList)
    }

    private fun initJobListRecyclerView(recyclerView: RecyclerView) {
        jobListAdapter = JobListAdapter(
            onJobClick = ::onJobClick,
        )

        recyclerView.run {
            adapter = jobListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun onJobClick(jobData: JobData) {
        TODO("Not yet implemented")
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}

class JobListAdapter(
    private val onJobClick: (JobData) -> Unit,
): ListAdapter<JobData, JobListAdapter.JobViewHolder>(JobDiffUtil) {

    class JobViewHolder(
        private val binding: ItemFindJobBinding,
        private val onJobClick: (JobData) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(jobData: JobData) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding =
            ItemFindJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return JobViewHolder(
            binding,
            onJobClick,
        )
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val feedData = getItem(position)
        if (feedData != null) {
            holder.bind(feedData)
        }
    }

    companion object JobDiffUtil : DiffUtil.ItemCallback<JobData>() {
        override fun areItemsTheSame(
            oldItem: JobData,
            newItem: JobData
        ): Boolean {
            return false
        }

        override fun areContentsTheSame(
            oldItem: JobData,
            newItem: JobData
        ): Boolean {
            return oldItem == newItem
        }
    }
}

