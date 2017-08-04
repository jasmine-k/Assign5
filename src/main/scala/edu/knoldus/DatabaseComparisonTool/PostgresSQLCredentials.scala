package edu.knoldus.DatabaseComparisonTool

import edu.knoldus.DatabaseComparisonTool.jdbc.Database

object PostgresSQLCredentials extends Database{

  override val url = "jdbc:postgresql://localhost:5432/postgres"
  override val driver = "org.postgresql.Driver"
  override val username = "postgres"
  override val password = ""

}
