package edu.knoldus.Services

import java.sql.Connection

import edu.knoldus.DatabaseComparisonTool.ReadWriteFromFile
import edu.knoldus.DatabaseComparisonTool.jdbc.Database
import edu.knoldus.Models.{TestCase, ParseCSV}


trait DatabaseService extends Database {

  val connection: Connection
  val fileName: String

  def queryTime(filePath: String): (List[TestCase], List[Long]) = {

    val testCaseList = ParseCSV.parseCSV(filePath)
    val timeTakenList = testCaseList.map {
      testCase => executeQueries(testCase, connection)
    }
    val testCasesZipTimeTaken = testCaseList zip timeTakenList
    val writeContentList = for{
      testCaseWithTimeTaken <- testCasesZipTimeTaken
    } yield "" + testCaseWithTimeTaken._1.testCaseId + ", " + testCaseWithTimeTaken._1.testCaseDescription +
      ", " + testCaseWithTimeTaken._1.query + ", " + testCaseWithTimeTaken._2
    val contentToWrite = writeContentList.mkString("\n")
    ReadWriteFromFile.write(fileName + "_Result.csv", contentToWrite, "/home/akshay/IdeaProjects/Scala0501/Assign0501/outputCSVFiles")
    closeConnection(connection)
    (testCaseList, timeTakenList)
  }
}
