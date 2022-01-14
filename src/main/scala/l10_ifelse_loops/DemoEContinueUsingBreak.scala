package l10_ifelse_loops
import util.control.Breaks._

object DemoEContinueUsingBreak {
  //this example acts like a Java continue statement
  def main(args: Array[String]): Unit = {
    val searchMe = "peter piper picked a peck of pickled peppers"
    var numPs = 0

    for (i <- 0 until searchMe.length) {
      breakable {
        if (searchMe.charAt(i) != 'p') {
          break  // break out of the 'breakable', continue the outside loop
        } else {
          numPs += 1
        }
      }
    }
    println("Found " + numPs + " p's in the string.")
  }
}
