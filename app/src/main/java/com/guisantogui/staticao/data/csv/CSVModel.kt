package com.guisantogui.staticao.data.csv


abstract class CSVModel {

    open var columnList = listOf("")

    abstract fun getHomeTeam(array: Array<String>): String
    abstract fun getAwayTeam(array: Array<String>): String

}