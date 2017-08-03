package edu.knoldus
package knoldus.DatabaseComparisonTool

import edu.knoldus.DatabaseComparisonTool.jdbc.Database
import edu.knoldus.Services.{MySQLService, PostgreSQLService, SQLiteService}


object runn extends App with Database {


  MySQLService.queryTime("/home/knoldus/CSVInputFiles/MySQLDDL.csv")
  PostgreSQLService.queryTime("/home/knoldus/CSVInputFiles/PostgreSQLDDL.csv")
  SQLiteService.queryTime("/home/knoldus/CSVInputFiles/SQLiteDDL.csv")

}
