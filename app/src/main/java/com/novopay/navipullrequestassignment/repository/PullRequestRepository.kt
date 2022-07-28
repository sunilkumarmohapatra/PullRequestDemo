package com.novopay.navipullrequestassignment.repository


import com.novopay.navipullrequestassignment.data.PullRequestResponse
import io.reactivex.Single


interface PullRequestRepository {
    fun getClosePullRequest(
        owner: String,
        repo: String,
        page: Int,
        perPage: Int,
        state: String
    ): Single<List<PullRequestResponse>>
}