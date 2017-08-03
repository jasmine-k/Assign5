package edu.knoldus.Services

import java.sql.Connection

import edu.knoldus.DatabaseComparisonTool.MySQLCredentials

object MySQLService extends DatabaseService{

  val connection: Connection = MySQLCredentials.connectionToDatabase
  val fileName: String = "MYSQL"

}
