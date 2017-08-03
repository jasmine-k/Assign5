package jdbc

import java.sql.DriverManager
import java.sql.Connection

import edu.knoldus.Models.ParseCSV

object ScalaJdbcConnectSelect extends App{

    // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/mysql"
    val username = "root"
    val password = "12345"

    // there's probably a better way to do this
    var connection:Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()

      val resultSet = statement.executeQuery("SELECT Host, User FROM user")
      while ( resultSet.next() ) {
        val host = resultSet.getString("host")
        val user = resultSet.getString("user")
        println("host, user = " + host + ", " + user)
      }
    } catch {
      case e => e.printStackTrace
    }
    connection.close()

    val parseCSV = new ParseCSV
    parseCSV.parseCSV()

}

