package edu.knoldus
package knoldus.DatabaseComparisonTool

import edu.knoldus.DatabaseComparisonTool.jdbc.Database
import edu.knoldus.Services.{MySQLService, PostgreSQLService, SQLiteService}


object runn extends App with Database {


  MySQLService.queryTime("/home/akshay/IdeaProjects/Scala0501/Assign0501/src/test/resources/CSVInputFiles/MySQLDDL.csv")
  PostgreSQLService.queryTime("/home/akshay/IdeaProjects/Scala0501/Assign0501/src/test/resources/CSVInputFiles/PostgreSQLDDL.csv")
  SQLiteService.queryTime("/home/akshay/IdeaProjects/Scala0501/Assign0501/src/test/resources/CSVInputFiles/SQLiteDDL.csv")

}
