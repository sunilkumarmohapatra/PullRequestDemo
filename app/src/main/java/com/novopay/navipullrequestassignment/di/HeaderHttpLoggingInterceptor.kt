package com.novopay.navipullrequestassignment.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HeaderHttpLoggingInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BodyHttpLoggingInterceptor
