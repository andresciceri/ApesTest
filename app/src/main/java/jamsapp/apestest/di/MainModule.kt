package jamsapp.apestest.di

import dagger.Module
import dagger.Provides
import jamsapp.apestest.data.interactors.IMainInteractor
import jamsapp.apestest.data.interactors.MainInteractor
import jamsapp.apestest.data.repositories.IMainRepository
import jamsapp.apestest.data.repositories.MainRepository

@Module
class MainModule {

    @Provides
    fun provideInteractor(): IMainInteractor {
        return MainInteractor()
    }

    @Provides
    fun provideRepository(): IMainRepository {
        return MainRepository()
    }
}