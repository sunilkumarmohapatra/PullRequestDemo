package com.novopay.navipullrequestassignment.presentation.main


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.novopay.navipullrequestassignment.data.PullRequestResponse
import com.novopay.navipullrequestassignment.databinding.ItemClosePullRequestBinding

class ClosePullRequestAdapter(private val context: Context) :
    RecyclerView.Adapter<ClosePullRequestAdapter.ClosePullRequestViewHolder>() {

    var pullRequestList = ArrayList<PullRequestResponse>()

    fun setList(pullRequestList: ArrayList<PullRequestResponse>) {
        this.pullRequestList.clear()
        this.pullRequestList = pullRequestList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ClosePullRequestViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemClosePullRequestBinding.inflate(inflater, parent, false)
        return ClosePullRequestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClosePullRequestViewHolder, position: Int) {
        holder.bind(pullRequestList[position])
    }

    override fun getItemCount(): Int {
        return pullRequestList.size
    }

    inner class ClosePullRequestViewHolder(var binding: ItemClosePullRequestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PullRequestResponse) {
            with(binding) {
                tvTitle.text = data.title
                tvName.text = data.user?.name
                tvCreatedDate.text = "Created On: ${data.createdDate?.split("T")?.get(0) ?: ""}"
                tvCloseDate.text = "Closed On: ${data.closedDate?.split("T")?.get(0) ?: ""}"
                Glide.with(context)
                    .load(data.user?.profileUrl)
                    .circleCrop()
                    .into(ivClientImage)
            }
        }
    }
}