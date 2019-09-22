package jamsapp.apestest.di

import dagger.Component
import jamsapp.apestest.data.interactors.MainInteractor
import jamsapp.apestest.views.main.MainViewModel

@Component(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(mainViewModel: MainViewModel)
    fun inject(mainInteractor: MainInteractor)
}