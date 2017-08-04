package edu.knoldus.Services

import java.sql.Connection


import edu.knoldus.DatabaseComparisonTool.{ReadWriteFromFile, MySQLCredentials}
import edu.knoldus.Models.{ParseCSV, TestCase}

object MySQLService extends DatabaseService{

  val connection: Connection = MySQLCredentials.connectionToDatabase
  val fileName: String = "MYSQL"
}
