package edu.knoldus.Services

import java.sql.Connection

import edu.knoldus.DatabaseComparisonTool.jdbc.Database


trait DatabaseService extends Database {

  val connection: Connection
  val fileName: String

  val fileContent = ReadWriteFromFile.read(filePath)
    val fileContentList = fileContent.split("\n").toList
    val testCaseList = fileContentList.map(testCase => CSVTestCaseParser.parseTestCase(testCase))
    val timeTakenList = testCaseList.map {
      testCase => executeQueries(testCase, connection)
    }
    val testCasesZipTimeTaken = testCaseList zip timeTakenList
    val writeContentList = for{
      testCaseWithTimeTaken <- testCasesZipTimeTaken
    } yield "" + testCaseWithTimeTaken._1.testCaseId + ", " + testCaseWithTimeTaken._1.testCaseDescription +
      ", " + testCaseWithTimeTaken._1.query + ", " + testCaseWithTimeTaken._2
    val contentToWrite = writeContentList.mkString("\n")
    ReadWriteFromFile.write(fileName + "_Result.csv", contentToWrite, "/home/knoldus/outputCSVFiles")
    closeConnection(connection)
  }
}
