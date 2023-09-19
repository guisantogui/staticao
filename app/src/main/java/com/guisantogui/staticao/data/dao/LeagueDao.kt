package com.guisantogui.staticao.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.guisantogui.staticao.data.entity.League
import kotlinx.coroutines.flow.Flow

@Dao
interface LeagueDao {

    @Upsert
    suspend fun upsertLeague(league: League)

    @Delete
    suspend fun deleteLeague(league: League)

    @Query("SELECT * FROM League ORDER BY leagueName ASC")
    fun getAll(): Flow<List<League>>


}