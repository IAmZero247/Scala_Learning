package pack09_ifelse_loops

object DemoAIfElse {
  def main(args: Array[String]): Unit = {
    val x = 2

    //    if (x > 5) {
    //      println("x is greater than 5")
    //    } else {
    //      println("x is less than or equal to 5")
    //    }

    if (x == 1) {
      println("x is equal to 1")
    } else if (x == 2){
      println("x is equal to 2")
    } else if (x == 3){
      println("x is equal to 3")
    } else {
      println("x is greater than 3")
    }
  }
}
