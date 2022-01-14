package l10_ifelse_loops

object DemoCForLoop2 {

  def main(args: Array[String]): Unit = {
    // List - similar to Arrays. List is immutable. i.e. you can not change to contents of a List once is defined
    println("================For loop for Collections==========================")
    var numbersList = List(1,2,3,4,5,6,7,8,9,10)

    for (i <- numbersList) {
      println("value of i is "  + i )
    }

    println("================For loop for Collections with filter==========================")
    for (i <- numbersList if i%2 ==0; if i != 4 ; if i !=6 ) {
      println("value of i is "  + i )
    }

    println("================For loop for Collections with filter with YIELD ==========================")

    var evenNumberList = for (i <- numbersList if i%2 ==0 ) yield i
    println (evenNumberList)   //it will give even number list List(2, 4, 6, 8, 10)

  }
}
