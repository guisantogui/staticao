package com.guisantogui.staticao.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guisantogui.staticao.data.dao.LeagueDao
import com.guisantogui.staticao.data.entity.League
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class LeagueViewModel @Inject constructor (): ViewModel() {

    @Inject lateinit var leagueDao: LeagueDao

    private val _sort = MutableStateFlow(1)

    private val _leagues = _sort.flatMapLatest {type ->
        when(type){
            1 -> leagueDao.getAll()
            else -> leagueDao.getAll()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    val leagues = _leagues


    fun onEvent(event: LeagueEvent){
        when(event){
            is LeagueEvent.DeleteLeague -> {
                viewModelScope.launch {
                    leagueDao.deleteLeague(event.league)
                }
            }
            is LeagueEvent.SaveLeague -> {
                viewModelScope.launch {
                    leagueDao.upsertLeague(League(leagueName = event.name))
                }
            }
        }
    }
}