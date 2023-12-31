package com.guisantogui.staticao.data.csv.premierleague

import com.guisantogui.staticao.data.csv.CSVModel

class PremierLeague2019Plus : CSVModel() {

    override var columnList = listOf(
        "Div",
        "Date",
        "Time",
        "HomeTeam",
        "AwayTeam",
        "FTHG",
        "FTAG",
        "FTR",
        "HTHG",
        "HTAG",
        "HTR",
        "Referee",
        "HS",
        "AS",
        "HST",
        "AST",
        "HF",
        "AF",
        "HC",
        "AC",
        "HY",
        "AY",
        "HR",
        "AR",
        "B365H",
        "B365D",
        "B365A",
        "BWH",
        "BWD",
        "BWA",
        "IWH",
        "IWD",
        "IWA",
        "PSH",
        "PSD",
        "PSA",
        "WHH",
        "WHD",
        "WHA",
        "VCH",
        "VCD",
        "VCA",
        "MaxH",
        "MaxD",
        "MaxA",
        "AvgH",
        "AvgD",
        "AvgA",
        "B365>2.5",
        "B365<2.5",
        "P>2.5",
        "P<2.5",
        "Max>2.5",
        "Max<2.5",
        "Avg>2.5",
        "Avg<2.5",
        "AHh",
        "B365AHH",
        "B365AHA",
        "PAHH",
        "PAHA",
        "MaxAHH",
        "MaxAHA",
        "AvgAHH",
        "AvgAHA",
        "B365CH",
        "B365CD",
        "B365CA",
        "BWCH",
        "BWCD",
        "BWCA",
        "IWCH",
        "IWCD",
        "IWCA",
        "PSCH",
        "PSCD",
        "PSCA",
        "WHCH",
        "WHCD",
        "WHCA",
        "VCCH",
        "VCCD",
        "VCCA",
        "MaxCH",
        "MaxCD",
        "MaxCA",
        "AvgCH",
        "AvgCD",
        "AvgCA",
        "B365C>2.5",
        "B365C<2.5",
        "PC>2.5",
        "PC<2.5",
        "MaxC>2.5",
        "MaxC<2.5",
        "AvgC>2.5",
        "AvgC<2.5",
        "AHCh",
        "B365CAHH",
        "B365CAHA",
        "PCAHH",
        "PCAHA",
        "MaxCAHH",
        "MaxCAHA",
        "AvgCAHH",
        "AvgCAHA"
    )

    override fun getHomeTeam(array: Array<String>): String {
        val homeTeamIndex = columnList.indexOf("HomeTeam")

        return array[homeTeamIndex].trim()
    }

    override fun getAwayTeam(array: Array<String>): String {
        val awayTeamIndex = columnList.indexOf("AwayTeam")

        return array[awayTeamIndex].trim()
    }
}
