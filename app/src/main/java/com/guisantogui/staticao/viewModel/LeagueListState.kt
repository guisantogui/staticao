package com.guisantogui.staticao.viewModel

import com.guisantogui.staticao.data.entity.League

data class LeagueListState(

    val leagues: List<League> = emptyList(),
    val searchTerm: String = ""
)
