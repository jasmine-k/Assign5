package edu.knoldus.Models

import java.io.FileReader

import com.opencsv.CSVReader
=import scala.collection.JavaConversions._

class ParseCSV {

  val OUTPUT_DIR = "src/test/input/MYSQL.csv"
  def parseCSV(): Unit ={

    val fileReader = new FileReader(OUTPUT_DIR)
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
        case error => throw new Exception
    }
    finally {
      fileReader.close()
    }

  }

}
