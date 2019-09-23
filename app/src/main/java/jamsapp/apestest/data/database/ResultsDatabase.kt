package jamsapp.apestest.data.database

import androidx.room.RoomDatabase
import androidx.room.Database

@Database(entities = [ResultsEntity::class], version = 1)
abstract class ResultsDatabase : RoomDatabase() {

    abstract fun resultsDao(): ResultsDAO
}