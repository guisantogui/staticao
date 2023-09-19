package com.guisantogui.staticao.data.repository

import android.util.Log
import com.guisantogui.staticao.data.dao.LeagueDao
import javax.inject.Inject


class LeagueRepositoryImpl @Inject constructor(
    val leagueDao: LeagueDao
) {

    init {

        Log.d("TAG", "HELLO LOG!")
    }
}