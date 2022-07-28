package com.novopay.navipullrequestassignment.domain

import com.novopay.navipullrequestassignment.data.PullRequestResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface GithubApiService {

    @GET("repos/{owner}/{repo}/pulls")
    fun getClosedPRs(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("state") state: String
    ): Single<List<PullRequestResponse>>
}