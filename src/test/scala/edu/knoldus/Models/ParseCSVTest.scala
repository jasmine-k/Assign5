/*
import com.opencsv.CSVParser
import edu.knoldus.Models.{ParseCSV, TestCase}


class CSVTestCaseParserTest extends org.scalatest.FunSuite {

  test("Testing CSVTestCaseParser")
  {
    val testCase= "1, Creating Employee table, DROP TABLE IF EXISTS Employee;, " +
      "\"CREATE TABLE Employee(name VARCHAR(20), EmployeeID INT, zipcode INT, " +
      "PhoneNo BIGINT);\", DROP TABLE Employee;"

    assert(ParseCSV.parseCSV(testCase) === TestCase(1, " Creating Employee table"
      , " DROP TABLE IF EXISTS Employee;", " CREATE TABLE Employee(name VARCHAR(20), EmployeeID INT, zipcode INT, PhoneNo BIGINT);",
      " DROP TABLE Employee;"))

  }
}*/
