package jamsapp.apestest.data.repositories

import io.reactivex.Observable
import jamsapp.apestest.data.dto.MoviesDTO
import jamsapp.apestest.network.ApesTestApiAdapter

class MainRepository: IMainRepository {

    override fun getAllMovies(): Observable<MoviesDTO>? {
        return ApesTestApiAdapter().getApesTestService()?.getAllMovies("b92fe4a1f037e397515a6b759239eaee558eef53","json")
    }
}