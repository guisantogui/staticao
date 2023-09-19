package com.guisantogui.staticao.data.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.guisantogui.staticao.data.dao.LeagueDao

@Database(entities = [League::class], version = 1)
abstract class StaticaoDatabase : RoomDatabase(){

    abstract fun leagueDao(): LeagueDao

}