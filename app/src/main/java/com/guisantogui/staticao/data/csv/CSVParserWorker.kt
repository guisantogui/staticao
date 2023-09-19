package com.guisantogui.staticao.data.csv

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.guisantogui.staticao.R
import com.guisantogui.staticao.data.csv.premierleague.PremierLeague2019Plus
import com.opencsv.CSVReader
import java.io.InputStreamReader

class CSVParserWorker(val context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {


    override fun doWork(): Result {

        val inputStream = context.resources.openRawResource(R.raw.e0)
        val inputStreamReader = InputStreamReader(inputStream)
        val csvReader = CSVReader(inputStreamReader)

        val data = Data.Builder()

        csvReader.skip(1)

        do {
            val nextLine = csvReader.readNext()
            if(nextLine != null){

                val model = PremierLeague2019Plus()
                val homeTeamName = model.getHomeTeam(nextLine)
                val awayTeamName = model.getAwayTeam(nextLine)


            }
            else{
                break
            }

        } while (true)



        return Result.success()
    }


}