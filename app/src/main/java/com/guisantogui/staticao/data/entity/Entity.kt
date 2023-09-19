package com.guisantogui.staticao.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "League")
data class League(
    @PrimaryKey(autoGenerate = true) val leagueId: Int = 0,
    val leagueName: String
)

@Entity(tableName = "Season")
data class Season(
    @PrimaryKey(autoGenerate = true) val seasonId: Int,
    val seasonName: String,
    val leagueName: String,
    val leagueCode: String
)

@Entity(tableName = "Team")
data class Team(
    @PrimaryKey(autoGenerate = true) val teamId: Int,
    val seasonTeamId: Int,
    val name: String,
    val logoLink: String
)


/*
@Entity(tableName = "Statistics")
data class Statistics(
    @PrimaryKey(autoGenerate = true) val statisticsId: Int,
    val wins: Int,
    val losses: Int,
    val draws: Int,
)*/
/*
//TeamStatistics
data class TeamSeasons(
    @Embedded val team: Season,
    @Relation(
        parentColumn = "seasonId",
        entityColumn = "seasonTeamId"
    ) val seasons: List<Team>
)


//TeamSeasonStatistics
data class TeamSeasonStatistics(
    @Embedded val team: Team,
    @Relation(
        entity = Season::class,
        parentColumn = "teamId",
        entityColumn = "userCreatorId"

    ) val teamSeason: List<TeamSeasons>

)
*/