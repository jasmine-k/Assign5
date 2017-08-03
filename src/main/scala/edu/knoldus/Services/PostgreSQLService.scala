package edu.knoldus.Services

import java.sql.Connection

import edu.knoldus.DatabaseComparisonTool.PostgresSQLCredentials

object PostgreSQLService extends DatabaseService{

  val connection:Connection = PostgresSQLCredentials.connectionToDatabase
  val fileName: String = "PostgreSQL"
}
