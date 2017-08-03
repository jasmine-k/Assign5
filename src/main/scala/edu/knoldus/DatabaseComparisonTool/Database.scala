package edu.knoldus.DatabaseComparisonTool
package jdbc

import java.sql.DriverManager
import java.sql.Connection

import com.sun.istack.internal.logging.Logger
import edu.knoldus.Models.TestCase

trait Database {

  val url: String = ""
  val driver: String = ""
  val username: String = ""
  val password: String = ""

  def connectionToDatabase: Connection ={

    val connection: Connection = try {
      Class.forName(driver)
      DriverManager.getConnection(url, username, password)
    }
    catch {
      case error: Exception => throw new Exception("Connection was not successful!!")
    }
    connection
  }

  def closeConnection(connection: Connection): Unit ={
    connection.close()
  }

  def executeQueries(testCase: TestCase, connection: Connection): Long = {

    val mysqlStatement = connection.createStatement()
    mysqlStatement.execute(testCase.preCondition)
    val start = System.nanoTime()
    val logger = Logger.getLogger(this.getClass)
    logger.info(s"${testCase.testCaseId} ${testCase.query}")
    mysqlStatement.execute(testCase.query)
    val end = System.nanoTime()
    mysqlStatement.execute(testCase.postCondition)
    end - start

  }

}
