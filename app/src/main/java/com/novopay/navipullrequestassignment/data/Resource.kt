package com.novopay.navipullrequestassignment.data

import androidx.annotation.Keep


data class Resource<out T> constructor(
    val status: Status,
    val data: T? = null,
    val throwable: Throwable? = null,
    val message: String? = null,
)