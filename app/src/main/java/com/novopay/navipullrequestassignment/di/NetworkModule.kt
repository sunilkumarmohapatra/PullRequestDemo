package com.novopay.navipullrequestassignment.di


import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.novopay.navipullrequestassignment.domain.GithubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [OkHttpClientModule::class])
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideGson(): Gson = GsonBuilder()
        .setLenient()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    @Provides
    fun provideGsonConverterFactory(gson: Gson?): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    fun provideRetrofit(
        @ApplicationContext context: Context?,
        okHttpClient: OkHttpClient?,
        gsonConverterFactory: GsonConverterFactory?,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory?
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }
}