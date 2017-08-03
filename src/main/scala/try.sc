import scala.util.matching.Regex

val bufferedSource = io.Source.fromFile("/home/akshay/IdeaProjects/Scala0501/Assign0501/src/test/input/MYSQL.csv")


for (line: String <- bufferedSource.getLines) {
  //val cols = line.split(",").map(_.trim)
//  println(cols.length)
  println(line+"\n")


  def extractValues(acc: String,extractedValuesList: List[String], quoteCount:Int, index: Integer): List[String] ={

    if(index == line.length){
      extractedValuesList
    }
    else {
      if(line(index) == ',' && quoteCount%2 == 0){

        extractValues("", acc :: extractedValuesList, quoteCount, index+1)
      }
      else if(line(index) == ',' && quoteCount%2 != 0){

        extractValues(acc + line(index), extractedValuesList, quoteCount, index+1)
      }
      else if(line(index) == '"' && (quoteCount+1)%2 == 0){
        extractValues("",(acc + line(index)):: extractedValuesList, quoteCount+1, index+1)

      }
      else if(line(index) == '"' && (quoteCount+1)%2 != 0){
        extractValues(acc + line(index), extractedValuesList, quoteCount+1, index+1)

      }
      else{
        extractValues(acc + line(index), extractedValuesList, quoteCount, index+1)

      }
    }
  }
  println(extractValues("",List(),0,0))

 // cols.foreach(println(_))
  // do whatever you want with the columns here
  //      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
}

bufferedSource.close

