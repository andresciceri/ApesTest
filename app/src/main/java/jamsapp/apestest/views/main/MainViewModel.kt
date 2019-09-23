package jamsapp.apestest.views.main

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jamsapp.apestest.data.interactors.IMainInteractor
import jamsapp.apestest.data.models.Results
import jamsapp.apestest.di.DaggerMainComponent
import jamsapp.apestest.views.SingleLiveEvent
import java.net.ConnectException
import javax.inject.Inject

class MainViewModel : ViewModel() {

    @Inject
    lateinit var interactor: IMainInteractor

    val resultListLiveData: MutableLiveData<List<Results>> by lazy {
        MutableLiveData<List<Results>>()
    }

    sealed class ViewEvent {
        class ResponseSuccess: ViewEvent()
        class ResponseError(val error: String?): ViewEvent()
    }

    var singleLiveEvent: SingleLiveEvent<ViewEvent> = SingleLiveEvent()

    init {
        DaggerMainComponent.builder().build().inject(this)
    }

    @SuppressLint("CheckResult")
    fun getAllMovies() {
        interactor.getAllMovies()?.subscribe({
            if(it.error == "OK"){
                singleLiveEvent.value = ViewEvent.ResponseSuccess()
                resultListLiveData.postValue(it.results)
            } else {
                singleLiveEvent.value = ViewEvent.ResponseError(it.error)
            }
        },{
            if(it is ConnectException)
                singleLiveEvent.value = ViewEvent.ResponseError("Error message 1")
            else
                singleLiveEvent.value = ViewEvent.ResponseError("Error message 2")
        })
    }
}