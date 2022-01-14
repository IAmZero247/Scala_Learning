package l10_ifelse_loops
import scala.util.control.Breaks

object DemoDForBreaks1 {


  def main(args: Array[String]): Unit = {
    var numbersList = List(1,2,3,4,5,6,7,8,9,10)
    val breakObject = new Breaks
    breakObject.breakable {

      for( i <-  numbersList if i %2 ==0){

        println("value of i is " + i)
        if (i==6){
          println("i am breaking at 6")
          breakObject.break()
        }
      }
    }
  }

}
