package com.novopay.navipullrequestassignment.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.novopay.navipullrequestassignment.data.PullRequestResponse
import com.novopay.navipullrequestassignment.data.Resource
import com.novopay.navipullrequestassignment.data.Status
import com.novopay.navipullrequestassignment.repository.PullRequestRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PullRequestVM @Inject constructor(private val repository: PullRequestRepository) :
    ViewModel() {
    val getPullRequestLiveData =
        MutableLiveData<Resource<List<PullRequestResponse>>>()

    fun getClosePullRequest() {
        repository.getClosePullRequest("Mindinventory", "LinkedInLogin", 1, 10, "closed")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<PullRequestResponse>> {
                override fun onSubscribe(d: Disposable) {
                    getPullRequestLiveData.postValue(Resource(Status.LOADING))
                }

                override fun onSuccess(t: List<PullRequestResponse>) {
                    getPullRequestLiveData.postValue(Resource(Status.SUCCESS, t))
                }

                override fun onError(e: Throwable) {
                    getPullRequestLiveData.postValue(Resource(Status.ERROR))
                }
            })

    }

}