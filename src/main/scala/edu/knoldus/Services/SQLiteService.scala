package edu.knoldus.Services

import java.sql.Connection

import edu.knoldus.DatabaseComparisonTool.SQLiteCredentials

object SQLiteService extends DatabaseService{

  val connection: Connection = SQLiteCredentials.connectionToDatabase
  val fileName: String = "SQLite"
}
