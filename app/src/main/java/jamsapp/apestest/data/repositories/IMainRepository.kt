package jamsapp.apestest.data.repositories

import io.reactivex.Observable
import jamsapp.apestest.data.dto.MoviesDTO

interface IMainRepository {
    fun getAllMovies(): Observable<MoviesDTO>?
}