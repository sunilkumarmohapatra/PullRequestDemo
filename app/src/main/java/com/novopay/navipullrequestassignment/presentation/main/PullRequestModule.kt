package com.novopay.navipullrequestassignment.presentation.main

import com.novopay.navipullrequestassignment.domain.GithubApiService
import com.novopay.navipullrequestassignment.repository.PullRequestRepository
import com.novopay.navipullrequestassignment.repository.PullRequestRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(ActivityComponent::class)
class PullRequestModule
{
    @Provides
    fun providePullRequestRepository(apiService: GithubApiService) : PullRequestRepository = PullRequestRepositoryImpl(apiService)
}