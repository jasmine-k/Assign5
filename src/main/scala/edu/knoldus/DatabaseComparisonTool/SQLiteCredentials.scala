package edu.knoldus.DatabaseComparisonTool

import edu.knoldus.DatabaseComparisonTool.jdbc.Database

object SQLiteCredentials extends Database{

  override val url = "jdbc:sqlite:/home/akshay/IdeaProjects/Scala0501/Assign0501/jasmine.db"
  override val driver = "org.sqlite.JDBC"
  override val username = ""
  override val password = ""

}
