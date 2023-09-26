package com.guisantogui.staticao.viewModel

import com.guisantogui.staticao.data.entity.League

interface LeagueEvent {

    data class SaveLeague(val name: String): LeagueEvent
    data class DeleteLeague(val league: League): LeagueEvent
    data class SetSearchTerm(val searchTerm: String): LeagueEvent

    object ListLeagues: LeagueEvent

}