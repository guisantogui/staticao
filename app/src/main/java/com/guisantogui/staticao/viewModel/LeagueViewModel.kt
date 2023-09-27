package com.guisantogui.staticao.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guisantogui.staticao.data.dao.LeagueDao
import com.guisantogui.staticao.data.entity.League
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class LeagueViewModel @Inject constructor (): ViewModel() {

    @Inject lateinit var leagueDao: LeagueDao


    private val _searchTerm = MutableStateFlow("")
    private val _state = MutableStateFlow(LeagueListState())

    private val _leagues = _searchTerm.flatMapLatest {term ->
        if(term != ""){
            leagueDao.getFiltered(_searchTerm.value)
        }
        else{
            leagueDao.getAll()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val state = combine(_state, _searchTerm, _leagues){ state, searchTerm, leagues ->
        state.copy(
            leagues = leagues,
            searchTerm = searchTerm
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), LeagueListState())


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
            is LeagueEvent.SetSearchTerm -> {
                _searchTerm.value = event.searchTerm
            }
        }
    }
}