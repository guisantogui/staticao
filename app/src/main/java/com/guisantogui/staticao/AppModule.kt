package com.guisantogui.staticao

import android.content.Context
import androidx.room.Room
import com.guisantogui.staticao.data.dao.LeagueDao
import com.guisantogui.staticao.data.entity.StaticaoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): StaticaoDatabase {
        return Room.databaseBuilder(context, StaticaoDatabase::class.java, "staticao_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideLeagueDao(staticaoDatabase: StaticaoDatabase): LeagueDao {
        return staticaoDatabase.leagueDao()
    }


}