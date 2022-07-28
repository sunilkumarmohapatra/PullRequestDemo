package com.novopay.navipullrequestassignment.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object OkHttpClientModule {

    @Provides
    @HeaderHttpLoggingInterceptor
    fun headerHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
    }

    @Provides
    @BodyHttpLoggingInterceptor
    fun bodyHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun getOkHttpClientBuilder(
        @HeaderHttpLoggingInterceptor headerHttpLoggingInterceptor: HttpLoggingInterceptor?,
        @BodyHttpLoggingInterceptor bodyHttpLoggingInterceptor: HttpLoggingInterceptor?
    ): OkHttpClient {

        return OkHttpClient().newBuilder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .retryOnConnectionFailure(false)
            .addInterceptor(headerHttpLoggingInterceptor as Interceptor)
            .addInterceptor(bodyHttpLoggingInterceptor as Interceptor)
            .build()
    }

}