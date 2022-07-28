package com.novopay.navipullrequestassignment.di


import com.novopay.navipullrequestassignment.domain.GithubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGithubApiService(retrofit: Retrofit): GithubApiService =
        retrofit.create(GithubApiService::class.java)

}