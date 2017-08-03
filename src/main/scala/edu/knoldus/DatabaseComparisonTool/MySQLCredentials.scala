package edu.knoldus.DatabaseComparisonTool

import edu.knoldus.DatabaseComparisonTool.jdbc.Database

object MySQLCredentials extends Database{

  override val url = "jdbc:mysql://localhost:3306/Company?allowMultiQueries=true"
  override val driver = "com.mysql.cj.jdbc.Driver"
  override val username = "root"
  override val password = "12345"

}
