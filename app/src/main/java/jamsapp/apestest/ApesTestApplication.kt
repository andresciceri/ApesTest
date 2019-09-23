package jamsapp.apestest

import android.app.Application
import android.content.Context
import androidx.room.Room
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import jamsapp.apestest.data.database.ResultsDatabase
import jamsapp.apestest.data.database.ResultsEntity

class ApesTestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        setupRoom()
    }

    private fun setupRoom() {

        val sessionEntity = ResultsEntity(1, "https://comicvine.gamespot.com/api/movie/4025-2/", "134218018")
        Observable.just(true)
            .observeOn(Schedulers.io())
            .subscribe {
                getDatabaseInstance()?.resultsDao()?.insert(sessionEntity)
                getDatabaseInstance()?.resultsDao()?.getAllAsync()?.subscribe {
                    val objectDb = it
                }
            }
    }

    companion object {
        private lateinit var instance: ApesTestApplication
        private var roomInstance: ResultsDatabase? = null

        fun getInstance(): ApesTestApplication {
            return instance
        }

        fun getAppContext(): Context {
            return instance.applicationContext
        }

        fun getDatabaseInstance(): ResultsDatabase? {
            if (roomInstance == null) {
                roomInstance = Room.databaseBuilder( instance,
                    ResultsDatabase::class.java,
                    "results-database"
                ).allowMainThreadQueries().build()
            }
            return roomInstance
        }
    }
}