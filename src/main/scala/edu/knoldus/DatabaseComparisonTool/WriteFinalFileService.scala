package edu.knoldus.DatabaseComparisonTool

import edu.knoldus.Models.TestCase

object WriteFinalFileService {

  def writeFinalFile(testCaseList: List[TestCase], mySQLTimeList: List[Long],
                     postgreSQLTimeList: List[Long], SQLiteTimeList: List[Long]) = {

    val listZip = testCaseList zip mySQLTimeList zip postgreSQLTimeList zip SQLiteTimeList map {
      case (((a,b),c),d) => (a,b,c,d)
    }

    ReadWriteFromFile.write("FinalResult.csv", listZip.map(tuple => tuple.productIterator.mkString(",")).mkString("\n"),
      "/home/knoldus/outputCSVFiles")
  }
}
