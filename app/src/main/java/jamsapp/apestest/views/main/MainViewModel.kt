package jamsapp.apestest.views.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import jamsapp.apestest.data.interactors.IMainInteractor
import jamsapp.apestest.di.DaggerMainComponent
import jamsapp.apestest.views.SingleLiveEvent
import java.net.ConnectException
import javax.inject.Inject

class MainViewModel : ViewModel() {

    @Inject
    lateinit var interactor: IMainInteractor

    sealed class ViewEvent {
        class ResponseSuccess: ViewEvent()
        class ResponseError(val error: String?): ViewEvent()
    }

    var singleLiveEvent: SingleLiveEvent<ViewEvent> = SingleLiveEvent()

    init {
        DaggerMainComponent.builder().build().inject(this)
    }

    @SuppressLint("CheckResult")
    fun getAllMovies(){
        interactor.getAllMovies()?.subscribe({
            /*if(it.success == true){
                singleLiveEvent.value = ViewEvent.ResponseSuccess()
            } else if (it.success == false) {
                singleLiveEvent.value = ViewEvent.ResponseError(it.message)
            }*/
        },{
            if(it is ConnectException)
                singleLiveEvent.value = ViewEvent.ResponseError("Error message")
            else
                singleLiveEvent.value = ViewEvent.ResponseError("Error message")
        })
    }
}