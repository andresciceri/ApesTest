package jamsapp.apestest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface ResultsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: ResultsEntity)

    @Query("SELECT * FROM ResultsEntity")
    fun getAll(): List<ResultsEntity>

    @Query("SELECT * FROM ResultsEntity")
    fun getAllAsync(): Observable<List<ResultsEntity>>

    @Query("select * from ResultsEntity where id=:id")
    fun getById(id: Int): ResultsEntity
}