package com.novopay.navipullrequestassignment.repository


import com.novopay.navipullrequestassignment.domain.GithubApiService
import javax.inject.Inject

class PullRequestRepositoryImpl @Inject constructor(private val apiService: GithubApiService) :
    PullRequestRepository {

    override fun getClosePullRequest(
        owner: String,
        repo: String,
        page: Int,
        perPage: Int,
        state: String
    ) =
        apiService.getClosedPRs(
            owner = owner,
            repo = repo,
            page = page,
            perPage = perPage,
            state = state
        )
}
