package edu.knoldus.Models

import java.io.FileReader

import com.opencsv.CSVReader
import scala.collection.JavaConversions._

object ParseCSV {

  def parseCSV(filePath: String): List[TestCase] ={

    val fileReader = new FileReader(filePath)
    try{
      val reader: CSVReader = new CSVReader(fileReader, ',', '\"')
      val queryList = for (
        row <- reader.readAll)
        yield {
          TestCase(row(0).toInt , row(1), row(2), row(3), row(4))
        }


      queryList.toList


    }
    catch{
        case error => throw error
    }
    finally {
      fileReader.close()
    }

  }

}
