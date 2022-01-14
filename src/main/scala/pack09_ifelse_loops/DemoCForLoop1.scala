package pack09_ifelse_loops

object DemoCForLoop1 {
  def main(args: Array[String]): Unit = {
    // it will execute for i from 1 to 10
    for (i <- 1 to 10) {
      println("value of i is " + i)
    }

    // it will execute for i from 1 until 10 / from 1 to 9
    for (i <- 1 until 10) {
      println("value of i is using until" + i)
    }

    println("================Nested Foor Loop=================================")
    // Nested for loop
    for (i <- 1 to 10) {
      for (j <- 1 to 10) {
        println("Value of i is " + i + " value of j is " + j)
      }
    }

    // Nested for loop - Scala
    for (i<- 1 to 10; j <- 1 to 5; k<- 1 to 2 ) {
      println("Value of i is " + i + " value of j is " + j  + " value of k is " + k)
    }
  }
}
