package com.novopay.navipullrequestassignment.data

import com.google.gson.annotations.SerializedName

data class PullRequestResponse(
    @SerializedName("title") var title: String?,
    @SerializedName("created_at") var createdDate: String?,
    @SerializedName("closed_at") var closedDate: String?,
    @SerializedName("user") var user: User?
) {
    data class User(
        @SerializedName("avatar_url") var profileUrl: String?,
        @SerializedName("login") var name: String?
    )
}